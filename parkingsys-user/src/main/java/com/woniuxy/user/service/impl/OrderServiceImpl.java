package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.Order;
import com.woniuxy.user.mapper.TOrderMapper;
import com.woniuxy.user.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<TOrderMapper, Order> implements IOrderService {

    private final TOrderMapper tOrderMapper;

    public OrderServiceImpl(TOrderMapper tOrderMapper){
        this.tOrderMapper = tOrderMapper;
    }

}
