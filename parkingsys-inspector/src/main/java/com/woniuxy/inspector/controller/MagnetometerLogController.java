package com.woniuxy.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.inspector.entity.MagnetometerLog;
import com.woniuxy.inspector.service.IMagnetometerLogService;
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
@RequestMapping("/magnetometer-log")
public class MagnetometerLogController {

    private final IMagnetometerLogService magnetometerLogServiceImpl;

    public MagnetometerLogController(IMagnetometerLogService magnetometerLogServiceImpl){
        this.magnetometerLogServiceImpl = magnetometerLogServiceImpl;
    }

}
