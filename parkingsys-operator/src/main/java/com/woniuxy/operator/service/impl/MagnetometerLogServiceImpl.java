package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.MagnetometerLog;
import com.woniuxy.operator.mapper.MagnetometerLogMapper;
import com.woniuxy.operator.service.IMagnetometerLogService;
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
public class MagnetometerLogServiceImpl extends ServiceImpl<MagnetometerLogMapper, MagnetometerLog> implements IMagnetometerLogService {

    private final MagnetometerLogMapper magnetometerLogMapper;

    public MagnetometerLogServiceImpl(MagnetometerLogMapper magnetometerLogMapper){
        this.magnetometerLogMapper = magnetometerLogMapper;
    }
}
