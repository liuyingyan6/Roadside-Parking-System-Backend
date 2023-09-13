package com.woniuxy.operator.mapper;

import com.woniuxy.operator.vo.MagnetometerVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Magnetometer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MagnetometerMapper extends BaseMapper<Magnetometer> {
    List<MagnetometerVO> selectPageByKeyword(@Param("skipRow") Integer skipRow,
                                             @Param("pageSize") Integer pageSize,
                                             @Param("magnetometerName") String magnetometerName,
                                             @Param("roadName") String roadName);

    Long selectTotalCount(@Param("magnetometerName") String magnetometerName,
                          @Param("roadName") String roadName);

    List<Magnetometer>findByName(String name);
}
