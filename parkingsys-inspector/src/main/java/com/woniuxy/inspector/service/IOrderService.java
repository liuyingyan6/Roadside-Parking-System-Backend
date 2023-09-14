package com.woniuxy.inspector.service;

import com.woniuxy.inspector.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
public interface IOrderService extends IService<Order> {

    void createOrder(Integer magnetometerId);
}
