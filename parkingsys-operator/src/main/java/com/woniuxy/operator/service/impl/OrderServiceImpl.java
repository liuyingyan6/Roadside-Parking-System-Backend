package com.woniuxy.operator.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.woniuxy.operator.vo.OrderVO;
import org.springframework.stereotype.Service;

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


}
