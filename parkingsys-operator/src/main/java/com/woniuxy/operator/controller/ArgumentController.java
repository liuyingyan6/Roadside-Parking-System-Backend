package com.woniuxy.operator.controller;

import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Argument;
import com.woniuxy.operator.service.IArgumentService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-08
 */
@RestController
@RequestMapping("/argument")
public class ArgumentController {

    private final IArgumentService argumentServiceImpl;

    public ArgumentController(IArgumentService argumentServiceImpl) {
        this.argumentServiceImpl = argumentServiceImpl;
    }

    @GetMapping("/findAll")
    public ResponseResult findAll(){
        List<Argument> list = argumentServiceImpl.list();
        return ResponseResult.ok(list);
    }



}
