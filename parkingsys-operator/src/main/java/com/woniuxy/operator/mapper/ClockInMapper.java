package com.woniuxy.operator.mapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.woniuxy.operator.dto.ClockInDTO;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.vo.ClockInVO;
import com.woniuxy.operator.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.ClockIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface ClockInMapper extends MPJBaseMapper<ClockIn> {
}
