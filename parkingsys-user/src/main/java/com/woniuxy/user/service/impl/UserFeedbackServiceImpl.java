package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.UserFeedback;
import com.woniuxy.user.mapper.UserFeedbackMapper;
import com.woniuxy.user.service.IUserFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback> implements IUserFeedbackService {

    private final UserFeedbackMapper userFeedbackMapper;

    public UserFeedbackServiceImpl(UserFeedbackMapper userFeedbackMapper){
        this.userFeedbackMapper = userFeedbackMapper;
    }

}
