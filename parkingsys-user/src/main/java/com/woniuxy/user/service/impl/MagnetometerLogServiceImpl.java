package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.MagnetometerLog;
import com.woniuxy.user.mapper.MagnetometerLogMapper;
import com.woniuxy.user.service.IMagnetometerLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class MagnetometerLogServiceImpl extends ServiceImpl<MagnetometerLogMapper, MagnetometerLog> implements IMagnetometerLogService {

    private final MagnetometerLogMapper magnetometerLogMapper;

    public MagnetometerLogServiceImpl(MagnetometerLogMapper magnetometerLogMapper){
        this.magnetometerLogMapper = magnetometerLogMapper;
    }

}
