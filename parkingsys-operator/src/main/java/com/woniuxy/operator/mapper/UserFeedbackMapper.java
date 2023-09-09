package com.woniuxy.operator.mapper;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.vo.UserFeedbackVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.UserFeedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserFeedbackMapper extends BaseMapper<UserFeedback> {

    List<UserFeedbackVO> findPage(@Param("userDTO") UserDTO userDTO);
}
