package com.woniuxy.user.controller;

import com.woniuxy.user.pojos.ResponseResult;
import com.woniuxy.user.service.IUserService;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/order")
public class TOrderController {

    private final ITOrderService tOrderServiceImpl;

    private final IUserService userServiceImpl;

    public TOrderController(ITOrderService tOrderServiceImpl, IUserService userServiceImpl){
        this.tOrderServiceImpl = tOrderServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/createOrder/{userId}/{parkingNum}")
    public ResponseResult createOrder(@PathVariable("userId") Long userId, @PathVariable("parkingNum") String parkingNum){
//        //        从请求头中Authorization拿出token，并且将token前面的bear去掉
//        token= token.replace("Bearer ", "");
//
////        使用jwt工具将token解析，并拿出userId
//        JWT jwt = JWTUtil.parseToken(token);
//        NumberWithFormat nwf = (NumberWithFormat)jwt.getPayload("id");
//
//        Long id = Long.valueOf(nwf.intValue());
        Long carId = userServiceImpl.selectById(userId);
        tOrderServiceImpl.createOrder(parkingNum,carId);
        return ResponseResult.ok();

    }

}
