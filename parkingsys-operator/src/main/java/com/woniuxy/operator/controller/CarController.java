package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.service.ICarService;
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
@RequestMapping("/car")
public class CarController {

    private final ICarService carServiceImpl;

    public CarController(ICarService carServiceImpl){
        this.carServiceImpl = carServiceImpl;
    }

}
