package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.UrlPermission;
import com.woniuxy.operator.service.IUrlPermissionService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单和接口权限定义 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@RestController
@RequestMapping("/url-permission")
public class UrlPermissionController {

    private final IUrlPermissionService urlPermissionServiceImpl;

    public UrlPermissionController(IUrlPermissionService urlPermissionServiceImpl){
        this.urlPermissionServiceImpl = urlPermissionServiceImpl;
    }

}
