package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.service.IUserService;
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
@RequestMapping("/user")
public class UserController {

    private final IUserService userServiceImpl;

    public UserController(IUserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

}
