package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.service.IOrderService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderServiceImpl;

    public OrderController(IOrderService orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @PostMapping("/page")
    public ResponseResult page(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize,
                               @Param("orderDto") OrderDTO orderDto) {
        //封装分页请求对象
        PageVO<OrderDTO> pageVO = orderServiceImpl.findAllPage(pageNum, pageSize, orderDto);
        return ResponseResult.ok(pageVO);
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Order order){
       orderServiceImpl.save(order);
        return ResponseResult.ok("添加成功");
    }
}
