package com.woniuxy.operator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.mapper.MagnetometerMapper;
import com.woniuxy.operator.service.IMagnetometerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.MagnetometerVO;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class MagnetometerServiceImpl extends ServiceImpl<MagnetometerMapper, Magnetometer> implements IMagnetometerService {

    private final MagnetometerMapper magnetometerMapper;

    public MagnetometerServiceImpl(MagnetometerMapper magnetometerMapper) {
        this.magnetometerMapper = magnetometerMapper;
    }

    @Override
    public List<MagnetometerVO> getByKeyword(String magnetometerName, String roadName) {
        List<MagnetometerVO> list = magnetometerMapper.selectByKeyword(magnetometerName, roadName);
        return list;
    }
}
