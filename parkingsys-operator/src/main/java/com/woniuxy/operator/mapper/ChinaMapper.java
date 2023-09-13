package com.woniuxy.operator.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.China;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChinaMapper extends BaseMapper<China> {

    List<China> findByChinaName(String name);
}
