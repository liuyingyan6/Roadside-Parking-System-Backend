package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.entity.UserFeedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.UserFeedbackVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IUserFeedbackService extends IService<UserFeedback> {

    PageInfo<UserFeedbackVO> findPage(Integer pageNum, Integer pageSize, UserDTO userDTO);
}
