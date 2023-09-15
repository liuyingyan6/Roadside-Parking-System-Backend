package com.woniuxy.operator.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.entity.InspectorRoad;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.enums.OrderStatusEnum;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.woniuxy.operator.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


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

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    // 支付统计饼图
    @Override
    public PayCountVO payCount(String startTime, String endTime) {
        return orderMapper.payCount(startTime,endTime);
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

    // 支付统计表单
    @Override
    public List<PayDateVO> payDate(String startTime, String endTime) {
        return orderMapper.payDate(startTime,endTime);
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

    // 资金流水
    @Override
    public CountOrderVO countOrder(String startTime, String endTime, Integer pageNum, Integer pageSize) {

        CountOrderVO countOrderVO = new CountOrderVO();

        Page<Order> page = new Page<>(pageNum, pageSize);

        // 分页查询时间范围内的所有订单
        IPage<Order> orderPage = orderMapper.selectPage(page, new QueryWrapper<Order>()
                .ge("create_time", startTime)
                .lt("create_time", endTime));

        List<Order> orders = orderPage.getRecords();
        countOrderVO.setOrderList(orders);
        countOrderVO.setTotal(orderPage.getTotal());

        BigDecimal totalAmount = BigDecimal.ZERO; // 总入账
        BigDecimal refundAmount = BigDecimal.ZERO; // 总出账

        for (Order order : orders) {
            if (order.getStatus() == 2) {
                totalAmount = totalAmount.add(order.getOrderAmount()); // 累加满足条件的订单金额
            }
            if (order.getStatus() == 4) {
                refundAmount = refundAmount.add(order.getOrderAmount()); // 累加满足条件的订单金额
            }
        }

        countOrderVO.setTotalAmount(totalAmount); // 将总入账set进countOrderVO中
        countOrderVO.setRefundAmount(refundAmount); // 将总出账set进countOrderVO中

        return countOrderVO;
    }

    @Override
    public List<RevenueVO> getRevenueInfo(String roadId, String startDate, String endDate) {
        return orderMapper.selectRevenueInfo(roadId, startDate, endDate);
    }

    @Override
    public OrderConversionVO getOrderConversionVOByKeyword(String roadId, String startDate, String endDate) {
        return orderMapper.selectOrderConversionVOByKeyword(roadId, startDate, endDate);
    }

    @Override
    public OrderConversionVO orderStatusCount(String inspectorId) {
        OrderConversionVO orderConversionVO = new OrderConversionVO();
        //根据id查询使用订单数量
        Long totalOrderCount = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                .eq(StringUtils.hasLength(inspectorId), Order::getInspectorId, inspectorId));
        orderConversionVO.setTotalOrderCount(totalOrderCount);
        //查询已支付的订单数量
        Long paidOrderCount = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                .eq(StringUtils.hasLength(inspectorId), Order::getInspectorId, inspectorId)
                .eq(Order::getStatus, OrderStatusEnum.ALREADY_PAY.getCode()));
        orderConversionVO.setPaidOrderCount(paidOrderCount);
        //查询异常订单数量
        Long unusualOrderCount = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                .eq(StringUtils.hasLength(inspectorId), Order::getInspectorId, inspectorId)
                .eq(Order::getStatus, OrderStatusEnum.OVERTIME_NO_PAY.getCode()));
        orderConversionVO.setUnusualOrderCount(unusualOrderCount);
        return orderConversionVO;
    }

    @Override
    public PageInfo<OrderVO> findAllByInspectorId(Integer pageNum, Integer pageSize, String inspectorId, OrderDTO orderDto) {
        PageHelper.startPage(pageNum, pageSize);

        String orderNumber = orderDto.getOrderNumber();
        String carNumber = orderDto.getCarNumber();
        Date startTime = orderDto.getStartTime();
        Date endTime = orderDto.getEndTime();
        Integer status = orderDto.getStatus();
        MPJLambdaWrapper<Order> wrapper = new MPJLambdaWrapper<Order>()
                .selectAll(Order.class)//查询InspectorRoad表全部字段
                .select(Car::getCarNumber)
                .select(Road::getRoadName)
                .leftJoin(Road.class, Road::getId, Order::getRoadId)
                .leftJoin(Car.class,Car::getId,Order::getCarId)
                .eq(StringUtils.hasLength(inspectorId),Order::getInspectorId,inspectorId)
                .likeRight(StringUtils.hasLength(orderNumber),Order::getOrderNumber,orderNumber)
                .likeRight(StringUtils.hasLength(carNumber),Car::getCarNumber,carNumber)
                .ge(Objects.nonNull(startTime),Order::getCreateTime,startTime)
                .le(Objects.nonNull(endTime),Order::getCreateTime,endTime)
                .eq(Objects.nonNull(status),Order::getStatus,status);

        List<OrderVO> orderVOList = orderMapper.selectJoinList(OrderVO.class, wrapper);

        return new PageInfo<>(orderVOList);
    }

    @Override
    public PageInfo<OrderVO> findAll2ByInspectorId(Integer pageNum, Integer pageSize, String inspectorId, OrderDTO orderDto) {
        PageHelper.startPage(pageNum, pageSize);

        String orderNumber = orderDto.getOrderNumber();
        String carNumber = orderDto.getCarNumber();
        Date startTime = orderDto.getStartTime();
        Date endTime = orderDto.getEndTime();
        Integer payType = orderDto.getPayType();
        MPJLambdaWrapper<Order> wrapper = new MPJLambdaWrapper<Order>()
                .selectAll(Order.class)//查询InspectorRoad表全部字段
                .select(Car::getCarNumber)
                .select(Road::getRoadName)
                .leftJoin(Road.class, Road::getId, Order::getRoadId)
                .leftJoin(Car.class,Car::getId,Order::getCarId)
                .eq(StringUtils.hasLength(inspectorId),Order::getInspectorId,inspectorId)
                .likeRight(StringUtils.hasLength(orderNumber),Order::getOrderNumber,orderNumber)
                .likeRight(StringUtils.hasLength(carNumber),Car::getCarNumber,carNumber)
                .ge(Objects.nonNull(startTime),Order::getCreateTime,startTime)
                .le(Objects.nonNull(endTime),Order::getCreateTime,endTime)
                .eq(Objects.nonNull(OrderStatusEnum.ALREADY_PAY.getCode()),Order::getStatus,OrderStatusEnum.ALREADY_PAY.getCode())
                .eq(Objects.nonNull(payType),Order::getPayType,payType);

        List<OrderVO> orderVOList = orderMapper.selectJoinList(OrderVO.class, wrapper);
        return new PageInfo<>(orderVOList);
    }


}
