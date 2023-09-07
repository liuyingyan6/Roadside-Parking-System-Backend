package com.woniuxy.operator.controller;

import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.service.IParkingService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final IParkingService parkingServiceImpl;

    public ParkingController(IParkingService parkingServiceImpl) {
        this.parkingServiceImpl = parkingServiceImpl;
    }

    @GetMapping("/list")
    public ResponseResult list() {
        return ResponseResult.ok(parkingServiceImpl.list());
    }
}
