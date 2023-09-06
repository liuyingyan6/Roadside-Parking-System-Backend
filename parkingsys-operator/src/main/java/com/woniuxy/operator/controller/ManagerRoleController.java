package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.ManagerRole;
import com.woniuxy.operator.service.IManagerRoleService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/manager-role")
public class ManagerRoleController {

    private final IManagerRoleService managerRoleServiceImpl;

    public ManagerRoleController(IManagerRoleService managerRoleServiceImpl){
        this.managerRoleServiceImpl = managerRoleServiceImpl;
    }

}
