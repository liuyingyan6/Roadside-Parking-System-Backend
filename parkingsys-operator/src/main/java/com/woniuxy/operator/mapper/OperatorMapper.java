package com.woniuxy.operator.mapper;
import com.woniuxy.operator.dto.OperatorDTO;
import com.woniuxy.operator.vo.OperatorVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Operator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-10
 */
@Mapper
public interface OperatorMapper extends BaseMapper<Operator> {

    List<OperatorVO> findPage(@Param("operatorDTO") OperatorDTO operatorDTO);
}
