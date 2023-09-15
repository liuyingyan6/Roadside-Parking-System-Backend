package com.woniuxy.operator.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.vo.InspectorVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Inspector;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface InspectorMapper extends MPJBaseMapper<Inspector> {


    List<InspectorVO> findPage(@Param("inspectorDTO") InspectorDTO inspectorDTO);
}
