package com.woniuxy.user.controller;

import com.woniuxy.user.pojos.ResponseResult;
import com.woniuxy.user.service.IOrderService;
import com.woniuxy.user.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderServiceImpl;

    public OrderController(IOrderService orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
    }


    //通过车牌号搜索订单
    @PostMapping("/findOrder")
    public ResponseResult findOrder(String carNumber){
        List<OrderVO> order = orderServiceImpl.findOrder(carNumber);
        return ResponseResult.ok(order);
    }
}
