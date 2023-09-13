package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import com.woniuxy.operator.entity.China;
import com.woniuxy.operator.service.IChinaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/china")
public class ChinaController {

    private final IChinaService chinaServiceImpl;

    public ChinaController(IChinaService chinaServiceImpl){
        this.chinaServiceImpl = chinaServiceImpl;
    }

    /**
     * 模糊查询
     */
    @GetMapping("/findsByName")
    public List<China>findsByName(@RequestParam String name){
        return chinaServiceImpl.findByChinaName(name);
    }
}
