package com.woniuxy.inspector.controller;

import com.woniuxy.inspector.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.inspector.entity.ClockIn;
import com.woniuxy.inspector.service.IClockInService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@RestController
@RequestMapping("/clock-in")
public class ClockInController {

    private final IClockInService clockInServiceImpl;

    public ClockInController(IClockInService clockInServiceImpl) {
        this.clockInServiceImpl = clockInServiceImpl;
    }

    @PostMapping("/addClock")
    public ResponseResult addClock(Integer num, String inspectorName) {
        clockInServiceImpl.addClock(num, inspectorName);
        return ResponseResult.ok();
    }
}
