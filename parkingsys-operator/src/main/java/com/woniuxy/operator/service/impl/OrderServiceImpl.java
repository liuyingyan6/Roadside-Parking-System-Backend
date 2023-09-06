package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

}
