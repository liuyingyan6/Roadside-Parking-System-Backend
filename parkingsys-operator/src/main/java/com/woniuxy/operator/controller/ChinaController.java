package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.China;
import com.woniuxy.operator.service.IChinaService;
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
@RequestMapping("/china")
public class ChinaController {

    private final IChinaService chinaServiceImpl;

    public ChinaController(IChinaService chinaServiceImpl){
        this.chinaServiceImpl = chinaServiceImpl;
    }

}
