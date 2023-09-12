package com.woniuxy.operator.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.MagnetometerLog;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.mapper.MagnetometerLogMapper;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.mapper.ParkingMapper;
import com.woniuxy.operator.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.woniuxy.operator.vo.CountOrderVO;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.RoadOrderVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final OrderMapper orderMapper;

    private final ParkingMapper parkingMapper;

    private final MagnetometerLogMapper magnetometerLogMapper;

    public OrderServiceImpl(OrderMapper orderMapper, ParkingMapper parkingMapper, MagnetometerLogMapper magnetometerLogMapper) {
        this.orderMapper = orderMapper;
        this.parkingMapper = parkingMapper;
        this.magnetometerLogMapper = magnetometerLogMapper;
    }


    @Override
    public List<OrderVO> findAll() {

        return orderMapper.findAll();
    }

    @Override
    public PageInfo<OrderVO> findPage(Integer pageNum, Integer pageSize, OrderDTO orderDto) {
        PageHelper.startPage(pageNum, pageSize);

        List<OrderVO> orderVOList = orderMapper.findAllPage(orderDto);

        return new PageInfo<>(orderVOList);
    }

    @Override
    public CountOrderVO countOrder(String startTime, String endTime,Integer pageNum, Integer pageSize) {

        CountOrderVO countOrderVO = new CountOrderVO();

        Page<Order> page = new Page<>(pageNum,pageSize);

        // 分页查询时间范围内的所有订单
        IPage<Order> orderPage = orderMapper.selectPage(page, new QueryWrapper<Order>()
                .ge("create_time", startTime)
                .lt("create_time", endTime));

        List<Order> orders = orderPage.getRecords();
        countOrderVO.setOrderList(orders);

        BigDecimal totalAmount = BigDecimal.ZERO; // 总入账
        BigDecimal refundAmount = BigDecimal.ZERO; // 总出账

        for (Order order : orders) {
            if (order.getStatus() == 0){
                totalAmount = totalAmount.add(order.getOrderAmount()); // 累加满足条件的订单金额
            }
            if (order.getStatus() == 3){
                refundAmount = refundAmount.add(order.getOrderAmount()); // 累加满足条件的订单金额
            }
        }

        countOrderVO.setTotalAmount(totalAmount); // 将总入账set进countOrderVO中
        countOrderVO.setRefundAmount(refundAmount); // 将总出账set进countOrderVO中

        return countOrderVO;
    }

    @Override
    public List<RoadOrderVO> getRoadOrderList(Integer roadId) {
        List<RoadOrderVO> list= orderMapper.getRoadOrderList(roadId);
        list.forEach(e->{
            BigDecimal payAmount = orderMapper.getPayAmount(e.getOrderDate(),roadId);
            e.setPayAmount(payAmount);
            RoadOrderVO roadOrderVO = orderMapper.getRefund(e.getOrderDate(),roadId);
            e.setRefundCount(roadOrderVO.getRefundCount());
            e.setRefundAmount(roadOrderVO.getRefundAmount());
            RoadOrderVO abnormal = orderMapper.getAbnormal(e.getOrderDate(),roadId);
            e.setAbnormalCount(abnormal.getAbnormalCount());
            e.setAbnormalAmount(abnormal.getAbnormalAmount());
            Integer payCount = orderMapper.getPayCount(e.getOrderDate(), roadId);
            e.setPayCount(payCount);
        });
        return list;
    }

    @Override
    public void createOrder(String parkingNum,Long carId) {
        //通过parkingNum查询路段id,parkingId
        Parking park = parkingMapper.selectOne(Wrappers.lambdaQuery(Parking.class).eq(Parking::getNumber, parkingNum));
        Long roadId = park.getRoadId();
        Long parkingId = park.getId();
        Integer magnetometerId = park.getMagnetometerId();
        MagnetometerLog magnetometerLog = magnetometerLogMapper.selectOne(Wrappers.lambdaQuery(MagnetometerLog.class)
                .eq(MagnetometerLog::getMagnetometerId, magnetometerId)
                .orderByAsc(MagnetometerLog::getId)
                .last("LIMIT 1"));
        Date magnetometerLogCreateTime = magnetometerLog.getCreateTime();

        Order order=new Order();
        order.setCarId(carId);
        order.setRoadId(roadId);
        order.setStatus(1);
        order.setParkingId(parkingId);
        order.setCreateTime(magnetometerLogCreateTime);
        orderMapper.insert(order);
    }


}
