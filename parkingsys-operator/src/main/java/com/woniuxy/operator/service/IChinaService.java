package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.China;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;


public interface IChinaService extends IService<China> {
    List<China> findByChinaName(String name);
}
