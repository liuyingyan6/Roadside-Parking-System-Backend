package com.woniuxy.operator.controller;

import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PermissionMenuVO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.woniuxy.operator.service.IUrlPermissionService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单和接口权限定义 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/urlPermission")
public class UrlPermissionController {

    private final IUrlPermissionService urlPermissionServiceImpl;

    public UrlPermissionController(IUrlPermissionService urlPermissionServiceImpl){
        this.urlPermissionServiceImpl = urlPermissionServiceImpl;
    }

    // 授权弹框：查询所有的权限数据
    @GetMapping("/all")
    public ResponseResult findAll(){
        List<PermissionMenuVO> list = urlPermissionServiceImpl.findAll();
        return ResponseResult.ok(list);
    }

    /**
     * 根据id查询权限
     */
    @GetMapping("/findPermission/{id}")
    public ResponseResult findPermission(@PathVariable("id") Long managerId) {
        List<PermissionMenuVO> list = urlPermissionServiceImpl.listByManagerId(managerId);
        return ResponseResult.ok(list);
    }

    // home左边框，根据用户id进行权限分配可以看到哪些
    // @GetMapping("/findPermission")
    // public ResponseResult findPermission(Long managerId){
    //     List<PermissionMenuVO> permissions = urlPermissionServiceImpl.listByManagerId(managerId);
    //     return ResponseResult.ok(permissions);
    // }
}
