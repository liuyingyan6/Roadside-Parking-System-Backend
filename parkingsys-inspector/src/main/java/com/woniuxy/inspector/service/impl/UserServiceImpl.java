package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.User;
import com.woniuxy.inspector.mapper.UserMapper;
import com.woniuxy.inspector.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

}
