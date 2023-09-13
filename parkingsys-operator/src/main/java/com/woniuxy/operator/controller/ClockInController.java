package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.ClockIn;
import com.woniuxy.operator.service.IClockInService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clockIn")
public class ClockInController {

    private final IClockInService clockInServiceImpl;

    public ClockInController(IClockInService clockInServiceImpl){
        this.clockInServiceImpl = clockInServiceImpl;
    }

}
