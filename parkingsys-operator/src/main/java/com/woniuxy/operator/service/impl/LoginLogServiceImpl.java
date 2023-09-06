package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.LoginLog;
import com.woniuxy.operator.mapper.LoginLogMapper;
import com.woniuxy.operator.service.ILoginLogService;
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
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

    private final LoginLogMapper loginLogMapper;

    public LoginLogServiceImpl(LoginLogMapper loginLogMapper){
        this.loginLogMapper = loginLogMapper;
    }

}
