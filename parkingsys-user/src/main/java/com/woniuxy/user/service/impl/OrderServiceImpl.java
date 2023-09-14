package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.Order;
import com.woniuxy.user.mapper.OrderMapper;
import com.woniuxy.user.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.user.vo.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderVO> findOrder(String carNumber) {
        return orderMapper.findOrder(carNumber);
    }
}
