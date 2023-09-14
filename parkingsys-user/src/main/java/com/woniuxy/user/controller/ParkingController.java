package com.woniuxy.user.controller;

import com.woniuxy.user.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.user.entity.Parking;
import com.woniuxy.user.service.IParkingService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final IParkingService parkingServiceImpl;

    public ParkingController(IParkingService parkingServiceImpl){
        this.parkingServiceImpl = parkingServiceImpl;
    }

    @GetMapping("/getParkingStatus")
    public ResponseResult getParkingStatus(String parkingNum){
        Long parkingStatus = parkingServiceImpl.getParkingStatus(parkingNum);
        if (parkingStatus!=1){
            return ResponseResult.ok("无效操作");
        }
        return ResponseResult.ok("确认停车");


    }

}
