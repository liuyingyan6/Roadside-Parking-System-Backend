package com.woniuxy.inspector.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.inspector.entity.ClockIn;
import com.woniuxy.inspector.entity.Inspector;
import com.woniuxy.inspector.mapper.ClockInMapper;
import com.woniuxy.inspector.mapper.InspectorMapper;
import com.woniuxy.inspector.service.IClockInService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class ClockInServiceImpl extends ServiceImpl<ClockInMapper, ClockIn> implements IClockInService {

    private final ClockInMapper clockInMapper;

    private final InspectorMapper inspectorMapper;

    public ClockInServiceImpl(ClockInMapper clockInMapper, InspectorMapper inspectorMapper){
        this.clockInMapper = clockInMapper;
        this.inspectorMapper = inspectorMapper;
    }

    @Override
    public void addClock(Integer num, String inspectorName) {
        if (num == 1) {
            Inspector inspector = inspectorMapper.selectOne(Wrappers.lambdaQuery(Inspector.class)
                    .eq(Inspector::getName, inspectorName));
            ClockIn clockIn = new ClockIn();
            clockIn.setInspectorId(inspector.getName());
            clockIn.setClockInStatus(1);
            clockIn.setDutyTime(new Date());
            clockInMapper.insert(clockIn);
        }else if (num == 2){
            ClockIn clockIn = clockInMapper.selectOne(Wrappers.lambdaUpdate(ClockIn.class)
                    .eq(ClockIn::getInspectorId, inspectorName));
            clockIn.setClosingTime(new Date());
            clockInMapper.updateById(clockIn);
        }
    }
}
