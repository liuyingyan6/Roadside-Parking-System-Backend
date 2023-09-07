package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.service.IParkingService;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final IParkingService parkingServiceImpl;

    public ParkingController(IParkingService parkingServiceImpl){
        this.parkingServiceImpl = parkingServiceImpl;
    }

    /**
     * 统计车位数
     */
    @GetMapping("/count")
    public int parkingCount(@RequestParam Integer id){
        return parkingServiceImpl.parkingCount(id);
    }
}
