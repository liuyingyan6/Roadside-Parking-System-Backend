package com.woniuxy.user.service;

import com.woniuxy.user.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.user.vo.OrderVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
public interface ITOrderService extends IService<TOrder> {

    List<OrderVO>findOrder(String carNumber);
}