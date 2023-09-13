package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.mapper.MagnetometerMapper;
import com.woniuxy.operator.service.IMagnetometerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.MagnetometerVO;
import com.woniuxy.operator.vo.PageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MagnetometerServiceImpl extends ServiceImpl<MagnetometerMapper, Magnetometer> implements IMagnetometerService {

    private final MagnetometerMapper magnetometerMapper;

    public MagnetometerServiceImpl(MagnetometerMapper magnetometerMapper) {
        this.magnetometerMapper = magnetometerMapper;
    }

    @Override
    public PageVO getPageByKeyword(Integer pageNum, Integer pageSize, String magnetometerName, String roadName) {
        List<MagnetometerVO> list = magnetometerMapper.selectPageByKeyword((pageNum - 1) * pageSize, pageSize, magnetometerName, roadName);
        Long total = magnetometerMapper.selectTotalCount(magnetometerName, roadName);
        return new PageVO(total, list);
    }

    @Override
    public List<Magnetometer> findsByName(String name) {
        List<Magnetometer> list = magnetometerMapper.findByName(name);
        return list;
    }
}
