package com.woniuxy.operator.mapper;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.vo.ManagerVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Manager;
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
public interface ManagerMapper extends BaseMapper<Manager> {

    List<ManagerVO> getAll(@Param("account") String account);
}
