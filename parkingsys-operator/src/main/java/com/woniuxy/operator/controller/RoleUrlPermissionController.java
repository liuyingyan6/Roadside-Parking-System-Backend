package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.operator.dto.AuthorizationDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/roleUrlPermission")
public class RoleUrlPermissionController {

    private final IRoleUrlPermissionService roleUrlPermissionServiceImpl;

    public RoleUrlPermissionController(IRoleUrlPermissionService roleUrlPermissionServiceImpl){
        this.roleUrlPermissionServiceImpl = roleUrlPermissionServiceImpl;
    }

    // 授权弹框：提交授权
    @PostMapping("/roleAuthorization")
    public ResponseResult roleAuthorization(@RequestBody AuthorizationDTO authorizationDTO){
        roleUrlPermissionServiceImpl.roleAuthorization(authorizationDTO);
        return ResponseResult.ok();
    }

    // 授权弹框：根据角色ID查询默认的权限
    @GetMapping("/default/{id}")
    public ResponseResult searchDefaultPermissionCheck(@PathVariable("id") Long id){
        List<RoleUrlPermission> list = roleUrlPermissionServiceImpl.
                list(Wrappers.lambdaQuery(RoleUrlPermission.class)
                        .eq(RoleUrlPermission::getRoleId, id));
        //使用Stream的map方法，完成数据映射  ids代表当前行id的用户有哪些权限
        List<Long> ids = list.stream().map(e -> e.getUrlPermissionId()).collect(Collectors.toList());
        return ResponseResult.ok(ids);
    }

}
