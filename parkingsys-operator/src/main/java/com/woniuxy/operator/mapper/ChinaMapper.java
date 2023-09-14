package com.woniuxy.operator.mapper;
import com.woniuxy.operator.entity.Charge;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.China;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


@Mapper
public interface ChinaMapper extends BaseMapper<China> {
    List<China> findByChinaName(String name);
}
