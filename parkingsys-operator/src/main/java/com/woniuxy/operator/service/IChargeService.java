package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.Charge;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IChargeService extends IService<Charge> {
    List<Charge> findByChargeId(Long id);
}
