package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Role;
import com.woniuxy.operator.service.IRoleService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleServiceImpl;

    public RoleController(IRoleService roleServiceImpl){
        this.roleServiceImpl = roleServiceImpl;
    }

}
