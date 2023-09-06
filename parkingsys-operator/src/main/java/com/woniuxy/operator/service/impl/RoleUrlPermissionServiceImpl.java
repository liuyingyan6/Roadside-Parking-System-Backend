package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.operator.dto.AuthorizationDTO;
import com.woniuxy.operator.entity.RoleUrlPermission;
import com.woniuxy.operator.mapper.RoleUrlPermissionMapper;
import com.woniuxy.operator.service.IRoleUrlPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

    // 授权弹框：提交授权
    @Transactional
    @Override
    public void roleAuthorization(AuthorizationDTO authorizationDTO) {
        // 删除原有的权限 authorizationDTO.getId代表当前行用户的id
        roleUrlPermissionMapper
                .delete(Wrappers.lambdaQuery(RoleUrlPermission.class)
                        .eq(RoleUrlPermission::getRoleId, authorizationDTO.getId()));
        // 新增权限
        authorizationDTO.getPermissionData().forEach(id -> {
            RoleUrlPermission roleUrlPermission = new RoleUrlPermission();
            roleUrlPermission.setRoleId(authorizationDTO.getId());
            roleUrlPermission.setUrlPermissionId(id);//此处id代表选择了哪些权限
            roleUrlPermissionMapper.insert(roleUrlPermission);
        });
    }
}
