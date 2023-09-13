package com.woniuxy.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.operator.dto.OperatorDTO;
import com.woniuxy.operator.entity.Operator;
import com.woniuxy.operator.vo.OperatorVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OperatorMapper extends BaseMapper<Operator> {

    List<OperatorVO> findPage(@Param("operatorDTO") OperatorDTO operatorDTO);
}
