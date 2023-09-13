package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.Magnetometer;
import com.woniuxy.inspector.mapper.MagnetometerMapper;
import com.woniuxy.inspector.service.IMagnetometerService;
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
public class MagnetometerServiceImpl extends ServiceImpl<MagnetometerMapper, Magnetometer> implements IMagnetometerService {

    private final MagnetometerMapper magnetometerMapper;

    public MagnetometerServiceImpl(MagnetometerMapper magnetometerMapper){
        this.magnetometerMapper = magnetometerMapper;
    }

}
