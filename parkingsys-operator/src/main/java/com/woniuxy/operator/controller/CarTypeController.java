package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.CarType;
import com.woniuxy.operator.service.ICarTypeService;
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
@RequestMapping("/car-type")
public class CarTypeController {

    private final ICarTypeService carTypeServiceImpl;

    public CarTypeController(ICarTypeService carTypeServiceImpl){
        this.carTypeServiceImpl = carTypeServiceImpl;
    }

}
