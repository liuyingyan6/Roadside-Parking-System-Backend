package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.PageVO;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IOrderService extends IService<Order> {

    List<OrderVO> findAll();
    PageVO<OrderDTO> findAllPage(Integer pageNum, Integer pageSize, OrderDTO orderDto);
}
