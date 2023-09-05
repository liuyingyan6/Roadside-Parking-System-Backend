package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.RoleUrlPermission;
import com.woniuxy.operator.mapper.RoleUrlPermissionMapper;
import com.woniuxy.operator.service.IRoleUrlPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 * 角色与菜单、接口权限的对应关系 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class RoleUrlPermissionServiceImpl extends ServiceImpl<RoleUrlPermissionMapper, RoleUrlPermission> implements IRoleUrlPermissionService {

    private final RoleUrlPermissionMapper roleUrlPermissionMapper;

    public RoleUrlPermissionServiceImpl(RoleUrlPermissionMapper roleUrlPermissionMapper){
        this.roleUrlPermissionMapper = roleUrlPermissionMapper;
    }

}
