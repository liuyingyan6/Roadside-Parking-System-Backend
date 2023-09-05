package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.entity.CarVO;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @GetMapping("/carList")
    public ResponseResult getCar(Integer pageSize,Integer pageNum,String key){
        Page<CarVO> page = Page.of(pageNum,pageSize);
        Page<CarVO> pv = carServiceImpl.getCarList(page,key);
        return ResponseResult.ok(pv);
    }



}
