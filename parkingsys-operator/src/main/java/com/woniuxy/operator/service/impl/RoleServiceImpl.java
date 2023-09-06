package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.ManagerRole;
import com.woniuxy.operator.entity.Role;
import com.woniuxy.operator.entity.RoleUrlPermission;
import com.woniuxy.operator.mapper.ManagerRoleMapper;
import com.woniuxy.operator.mapper.RoleMapper;
import com.woniuxy.operator.mapper.RoleUrlPermissionMapper;
import com.woniuxy.operator.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

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

    private final ManagerRoleMapper managerRoleMapper;

    private final RoleUrlPermissionMapper roleUrlPermissionMapper;

    public RoleServiceImpl(RoleMapper roleMapper, ManagerRoleMapper managerRoleMapper, RoleUrlPermissionMapper roleUrlPermissionMapper){
        this.roleMapper = roleMapper;
        this.managerRoleMapper = managerRoleMapper;
        this.roleUrlPermissionMapper = roleUrlPermissionMapper;
    }

    // 分页加载表单数据&查询
    @Override
    public PageVO<Role> findAll2Page(Page<Role> page, String name) {

        Page<Role> rolePage = roleMapper.selectPage(page, Wrappers.lambdaQuery(Role.class)
                .likeRight(StringUtils.hasLength(name), Role::getName, name));
        return new PageVO<>(rolePage.getTotal(),rolePage.getRecords());
    }

    // 删除
    @Transactional(isolation= Isolation.REPEATABLE_READ)
    @Override
    public void deleteRole(Long id) {
        //与用户表
        managerRoleMapper
                .delete(Wrappers.lambdaQuery(ManagerRole.class)
                        .eq(ManagerRole::getRoleId,id));
        //与权限表
        roleUrlPermissionMapper
                .delete(Wrappers.lambdaQuery(RoleUrlPermission.class)
                        .eq(RoleUrlPermission::getRoleId,id));
        //删除自己
        roleMapper.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = roleMapper.selectList(null);
        return roles;
    }
}
