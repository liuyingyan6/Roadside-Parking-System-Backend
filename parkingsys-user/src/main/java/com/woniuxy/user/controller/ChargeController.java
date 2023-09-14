package com.woniuxy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.user.entity.Charge;
import com.woniuxy.user.service.IChargeService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@RestController
@RequestMapping("/charge")
public class ChargeController {

    private final IChargeService chargeServiceImpl;

    public ChargeController(IChargeService chargeServiceImpl){
        this.chargeServiceImpl = chargeServiceImpl;
    }

}