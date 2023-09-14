package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Charge;
import com.woniuxy.operator.mapper.ChargeMapper;
import com.woniuxy.operator.service.IChargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ChargeServiceImpl extends ServiceImpl<ChargeMapper, Charge> implements IChargeService {

    private final ChargeMapper chargeMapper;

    public ChargeServiceImpl(ChargeMapper chargeMapper){
        this.chargeMapper = chargeMapper;
    }

    @Override
    public List<Charge> findByChargeId(Long id) {
        List<Charge> list = chargeMapper.findByChargeId(id);
        return list;
    }
}
