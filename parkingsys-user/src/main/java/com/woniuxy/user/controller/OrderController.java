package com.woniuxy.user.controller;

import org.springframework.web.bind.annotation.*;
import com.woniuxy.user.service.IOrderService;
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
@RequestMapping("/t-order")
public class OrderController {

    private final IOrderService tOrderServiceImpl;

    public OrderController(IOrderService tOrderServiceImpl){
        this.tOrderServiceImpl = tOrderServiceImpl;
    }

}
