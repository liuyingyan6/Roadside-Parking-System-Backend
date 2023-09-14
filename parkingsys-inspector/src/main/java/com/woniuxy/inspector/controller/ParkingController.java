package com.woniuxy.inspector.controller;

import com.woniuxy.inspector.pojos.ResponseResult;
import com.woniuxy.inspector.vo.ParkingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.inspector.entity.Parking;
import com.woniuxy.inspector.service.IParkingService;
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
@RequestMapping("/parking")
public class ParkingController {

    private final IParkingService parkingServiceImpl;

    public ParkingController(IParkingService parkingServiceImpl){
        this.parkingServiceImpl = parkingServiceImpl;
    }

    //故障设备远程搜索
    @GetMapping("/find")
    public ResponseResult find(){
        List<ParkingVO> parkingVOS = parkingServiceImpl.find();
        return ResponseResult.ok(parkingVOS);
    }
}
