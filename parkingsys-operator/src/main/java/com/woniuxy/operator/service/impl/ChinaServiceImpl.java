package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.China;
import com.woniuxy.operator.mapper.ChinaMapper;
import com.woniuxy.operator.service.IChinaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class ChinaServiceImpl extends ServiceImpl<ChinaMapper, China> implements IChinaService {

    private final ChinaMapper chinaMapper;

    public ChinaServiceImpl(ChinaMapper chinaMapper){
        this.chinaMapper = chinaMapper;
    }

    @Override
    public List<China> findByChinaName(String name) {
        return chinaMapper.findByChinaName(name);
    }
}
