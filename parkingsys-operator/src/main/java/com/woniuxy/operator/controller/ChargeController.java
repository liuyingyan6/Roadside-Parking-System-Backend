package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.operator.pojos.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Charge;
import com.woniuxy.operator.service.IChargeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charge")
public class ChargeController {

    private final IChargeService chargeServiceImpl;

    public ChargeController(IChargeService chargeServiceImpl){
        this.chargeServiceImpl = chargeServiceImpl;
    }

    @GetMapping("/findByCid")
    @ApiOperation("查询所有规则")
    public ResponseResult findByCid(){
        List<Charge> list = chargeServiceImpl.list(Wrappers.lambdaQuery(Charge.class).eq(Charge::getCid,0));
        return  ResponseResult.ok(list);
    }
    @GetMapping("/findByChargeId/{id}")
    public ResponseResult findByChargeId(@PathVariable("id") Long id){
        List<Charge> list = chargeServiceImpl.findByChargeId(id);
        return ResponseResult.ok(list);
    }
}
