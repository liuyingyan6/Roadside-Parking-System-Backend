package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.MagnetometerLog;
import com.woniuxy.inspector.mapper.MagnetometerLogMapper;
import com.woniuxy.inspector.service.IMagnetometerLogService;
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
public class MagnetometerLogServiceImpl extends ServiceImpl<MagnetometerLogMapper, MagnetometerLog> implements IMagnetometerLogService {

    private final MagnetometerLogMapper magnetometerLogMapper;

    public MagnetometerLogServiceImpl(MagnetometerLogMapper magnetometerLogMapper){
        this.magnetometerLogMapper = magnetometerLogMapper;
    }

}
