package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Role;
import com.woniuxy.operator.mapper.RoleMapper;
import com.woniuxy.operator.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper){
        this.roleMapper = roleMapper;
    }

}
