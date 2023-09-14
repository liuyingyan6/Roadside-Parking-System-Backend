package com.woniuxy.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.user.entity.*;
import com.woniuxy.user.mapper.OrderMapper;
import com.woniuxy.user.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.user.vo.OrderVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderVO> findByUserId(Long userId, Integer status) {
        MPJLambdaWrapper<Order> wrapper = new MPJLambdaWrapper<Order>()
                .selectAll(Order.class)
                .select(Car::getCarNumber)
                .selectAs(Parking::getNumber, OrderVO::getParkingNumber)
                .select(Road::getRoadName)
                .leftJoin(Car.class, Car::getId, Order::getCarId)
                .leftJoin(Road.class, Road::getId, Order::getRoadId)
                .leftJoin(Parking.class, Parking::getId, Order::getParkingId)
                .eq(Objects.nonNull(userId), Car::getUserId, userId)
                .eq(Objects.nonNull(status), Order::getStatus, status);

        List<OrderVO> orderVOList = orderMapper.selectJoinList(OrderVO.class, wrapper);
        return orderVOList;
    }


}
