package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.service.IOrderService;
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
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderServiceImpl;

    public OrderController(IOrderService orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
    }

}
