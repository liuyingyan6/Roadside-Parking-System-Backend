package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.RoleUrlPermission;
import com.woniuxy.operator.service.IRoleUrlPermissionService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色与菜单、接口权限的对应关系 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/role-url-permission")
public class RoleUrlPermissionController {

    private final IRoleUrlPermissionService roleUrlPermissionServiceImpl;

    public RoleUrlPermissionController(IRoleUrlPermissionService roleUrlPermissionServiceImpl){
        this.roleUrlPermissionServiceImpl = roleUrlPermissionServiceImpl;
    }

}
