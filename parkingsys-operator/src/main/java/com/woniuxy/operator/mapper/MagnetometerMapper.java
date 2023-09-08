package com.woniuxy.operator.mapper;

import com.woniuxy.operator.vo.MagnetometerVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Magnetometer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface MagnetometerMapper extends BaseMapper<Magnetometer> {
    List<MagnetometerVO> selectByKeyword(@Param("magnetometerName") String magnetometerName,
                                         @Param("roadName") String roadName);


}
