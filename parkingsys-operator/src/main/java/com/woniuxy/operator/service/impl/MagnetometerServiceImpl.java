package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.mapper.MagnetometerMapper;
import com.woniuxy.operator.service.IMagnetometerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.MagnetometerVO;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
    public PageVO getPageByKeyword(Integer pageNum, Integer pageSize, Integer magnetometerId, String magnetometerName, String roadName) {
        List<MagnetometerVO> list = magnetometerMapper.selectPageByKeyword((pageNum - 1) * pageSize, pageSize, magnetometerId, magnetometerName, roadName);
        Long total = magnetometerMapper.selectTotalCount(magnetometerId, magnetometerName, roadName);
        return new PageVO(total,list);
    }
}
