package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.ParkingAi;
import com.woniuxy.operator.service.IParkingAiService;
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
@RequestMapping("/parking-ai")
public class ParkingAiController {

    private final IParkingAiService parkingAiServiceImpl;

    public ParkingAiController(IParkingAiService parkingAiServiceImpl){
        this.parkingAiServiceImpl = parkingAiServiceImpl;
    }

}
