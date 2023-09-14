package com.woniuxy.operator.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Charge;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


@Mapper
public interface ChargeMapper extends BaseMapper<Charge> {
    List<Charge> findByChargeId(Long id);
}
