package com.woniuxy.operator.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.woniuxy.operator.vo.CountOrderVO;
import com.woniuxy.operator.vo.OrderConversionVO;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.RevenueVO;
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

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
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

        BigDecimal totalAmount = BigDecimal.ZERO; // 总入账
        BigDecimal refundAmount = BigDecimal.ZERO; // 总出账

        for (Order order : orders) {
            if (order.getStatus() == 0) {
                totalAmount = totalAmount.add(order.getOrderAmount()); // 累加满足条件的订单金额
            }
            if (order.getStatus() == 3) {
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


}
