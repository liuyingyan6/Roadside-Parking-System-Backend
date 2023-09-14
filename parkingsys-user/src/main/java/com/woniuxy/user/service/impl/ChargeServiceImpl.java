package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.Charge;
import com.woniuxy.user.mapper.ChargeMapper;
import com.woniuxy.user.service.IChargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class ChargeServiceImpl extends ServiceImpl<ChargeMapper, Charge> implements IChargeService {

    private final ChargeMapper chargeMapper;

    public ChargeServiceImpl(ChargeMapper chargeMapper){
        this.chargeMapper = chargeMapper;
    }

}
