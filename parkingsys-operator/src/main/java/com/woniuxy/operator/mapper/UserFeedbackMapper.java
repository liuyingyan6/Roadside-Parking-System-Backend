package com.woniuxy.operator.mapper;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.vo.UserFeedbackVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.UserFeedback;
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
public interface UserFeedbackMapper extends BaseMapper<UserFeedback> {
    //分页
    List<UserFeedbackVO> findPage(@Param("userDTO") UserDTO userDTO);
}
