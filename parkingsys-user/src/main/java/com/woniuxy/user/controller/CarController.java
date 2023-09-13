package com.woniuxy.user.controller;

import com.woniuxy.user.pojos.ResponseResult;
import com.woniuxy.user.vo.CarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.user.entity.Car;
import com.woniuxy.user.service.ICarService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/car")
public class CarController {

    private final ICarService carServiceImpl;

    public CarController(ICarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    //绑定车牌号
    @PostMapping("/add")
    public ResponseResult add(@RequestBody Car car){
        carServiceImpl.save(car);
        return ResponseResult.ok("绑定成功");
    }


}
