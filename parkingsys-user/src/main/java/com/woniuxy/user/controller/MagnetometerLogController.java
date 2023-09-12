package com.woniuxy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.user.entity.MagnetometerLog;
import com.woniuxy.user.service.IMagnetometerLogService;
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
@RequestMapping("/magnetometer-log")
public class MagnetometerLogController {

    private final IMagnetometerLogService magnetometerLogServiceImpl;

    public MagnetometerLogController(IMagnetometerLogService magnetometerLogServiceImpl){
        this.magnetometerLogServiceImpl = magnetometerLogServiceImpl;
    }

}
