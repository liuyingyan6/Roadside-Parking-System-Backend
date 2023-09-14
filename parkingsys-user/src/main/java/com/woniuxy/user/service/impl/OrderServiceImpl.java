package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.TOrder;
import com.woniuxy.user.mapper.TOrderMapper;
import com.woniuxy.user.service.ITOrderService;
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
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    private final TOrderMapper tOrderMapper;

    public TOrderServiceImpl(TOrderMapper tOrderMapper){
        this.tOrderMapper = tOrderMapper;
    }

    @Override
    public List<OrderVO> findOrder(String carNumber) {
        return tOrderMapper.findOrder(carNumber);
    }
}
