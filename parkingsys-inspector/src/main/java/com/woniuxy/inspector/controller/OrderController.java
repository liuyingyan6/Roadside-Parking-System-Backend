package com.woniuxy.inspector.controller;

import com.woniuxy.inspector.pojos.ResponseResult;
import com.woniuxy.inspector.service.impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.woniuxy.inspector.service.IOrderService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderServiceImpl;

    public OrderController(IOrderService orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
    }

    // 增加订单：拿到地磁id去查parking表拿到parking的id和road_id，car_id手动输入，state为1待支付
    // 将parking表中的state改为0有车
    @PostMapping("/createOrder")
    public ResponseResult createOrder(Integer magnetometerId){
        System.out.println("magnetometerId==========="+magnetometerId);
        System.out.println("getClass==========="+magnetometerId.getClass());
        orderServiceImpl.createOrder(magnetometerId);
        return ResponseResult.ok();
    }

}
