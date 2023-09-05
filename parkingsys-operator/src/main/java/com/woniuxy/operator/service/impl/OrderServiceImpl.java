package com.woniuxy.operator.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.PageVO;
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
    public PageVO<OrderDTO> findAllPage(Integer pageNum, Integer pageSize, OrderDTO orderDto) {
//        List<OrderDTO> orderDTOList = orderMapper.findAllPage(pageNum, pageSize, orderDto);
        Page<OrderDTO>page=new Page<>(pageNum,pageSize);
        PageVO<OrderDTO>pageVO=new PageVO<>();
        pageVO.setPageNum(page.getCurrent());
        pageVO.setPageSize(page.getSize());
        IPage<OrderDTO> allPage = orderMapper.findAllPage(page, orderDto);

        pageVO.setTotal(allPage.getTotal());
        pageVO.setRecords(allPage.getRecords());
        return pageVO;
    }




}
