package com.woniuxy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.user.entity.User;
import com.woniuxy.user.service.IUserService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userServiceImpl;

    public UserController(IUserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

}
