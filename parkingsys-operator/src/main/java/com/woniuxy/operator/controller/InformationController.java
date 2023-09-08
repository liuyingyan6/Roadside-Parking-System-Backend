package com.woniuxy.operator.controller;

import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Information;
import com.woniuxy.operator.service.IInformationService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-07
 */
@RestController
@RequestMapping("/information")
public class InformationController {

    private final IInformationService informationServiceImpl;

    public InformationController(IInformationService informationServiceImpl) {
        this.informationServiceImpl = informationServiceImpl;
    }


    @GetMapping("/findAll")
    public ResponseResult findAll() {
        Information information = informationServiceImpl.getById(1);
        return ResponseResult.ok(information);
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody Information information) {
        informationServiceImpl.saveOrUpdate(information);
        return ResponseResult.ok();
    }

}
