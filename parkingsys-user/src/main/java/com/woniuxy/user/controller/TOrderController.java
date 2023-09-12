package com.woniuxy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.user.entity.TOrder;
import com.woniuxy.user.service.ITOrderService;
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
public class TOrderController {

    private final ITOrderService tOrderServiceImpl;

    public TOrderController(ITOrderService tOrderServiceImpl){
        this.tOrderServiceImpl = tOrderServiceImpl;
    }

}
