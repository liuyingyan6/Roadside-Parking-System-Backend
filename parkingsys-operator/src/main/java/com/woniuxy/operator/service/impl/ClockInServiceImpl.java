package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.ClockIn;
import com.woniuxy.operator.mapper.ClockInMapper;
import com.woniuxy.operator.service.IClockInService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class ClockInServiceImpl extends ServiceImpl<ClockInMapper, ClockIn> implements IClockInService {

    private final ClockInMapper clockInMapper;

    public ClockInServiceImpl(ClockInMapper clockInMapper){
        this.clockInMapper = clockInMapper;
    }

}
