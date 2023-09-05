package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.mapper.UserMapper;
import com.woniuxy.operator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

}
