package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Pda;
import com.woniuxy.operator.service.IPdaService;
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
@RequestMapping("/pda")
public class PdaController {

    private final IPdaService pdaServiceImpl;

    public PdaController(IPdaService pdaServiceImpl){
        this.pdaServiceImpl = pdaServiceImpl;
    }

}
