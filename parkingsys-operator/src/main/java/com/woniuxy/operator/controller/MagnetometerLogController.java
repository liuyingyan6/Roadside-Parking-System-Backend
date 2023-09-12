package com.woniuxy.operator.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.Magnetometer;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.service.IMagnetometerService;
import com.woniuxy.operator.service.IParkingService;
import org.springframework.web.bind.annotation.*;

import com.woniuxy.operator.entity.MagnetometerLog;
import com.woniuxy.operator.service.IMagnetometerLogService;
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
@RequestMapping("/magnetometerLog")
public class MagnetometerLogController {

    private final IMagnetometerLogService magnetometerLogServiceImpl;
    private final IMagnetometerService magnetometerServiceImpl;
    private final IParkingService parkingServiceImpl;

    public MagnetometerLogController(IMagnetometerLogService magnetometerLogServiceImpl, IMagnetometerService magnetometerServiceImpl, IParkingService parkingServiceImpl) {
        this.magnetometerLogServiceImpl = magnetometerLogServiceImpl;
        this.magnetometerServiceImpl = magnetometerServiceImpl;
        this.parkingServiceImpl = parkingServiceImpl;
    }

    //    @Transactional
    @PostMapping("/carIn")
    public ResponseResult carIn(Integer id) {
        Magnetometer magnetometer = magnetometerServiceImpl.getById(id);
        magnetometerLogServiceImpl.save(new MagnetometerLog(null, id, magnetometer.getStatus(), 0, DateTime.now(), DateTime.now(), 0));
        parkingServiceImpl.update(new UpdateWrapper<Parking>()
                .eq("geomagnetic_id", id)
                .set("status", 0));
        return ResponseResult.ok();
    }

    //    @Transactional
    @PostMapping("/carOut")
    public ResponseResult carOut(Integer id) {
        Magnetometer magnetometer = magnetometerServiceImpl.getById(id);
        magnetometerLogServiceImpl.save(new MagnetometerLog(null, id, magnetometer.getStatus(), 1, DateTime.now(), DateTime.now(), 0));
        parkingServiceImpl.update(new UpdateWrapper<Parking>()
                .eq("geomagnetic_id", id)
                .set("status", 1));
        return ResponseResult.ok();
    }

    @GetMapping("/getPageById")
    public ResponseResult getPageById(Integer pageNum, Integer pageSize,Integer id) {
        Page<MagnetometerLog> pageData = new Page<>(pageNum, pageSize);
        Page<MagnetometerLog> page = magnetometerLogServiceImpl.page(pageData, new QueryWrapper<MagnetometerLog>().eq("magnetometer_id", id));
        return ResponseResult.ok(page);
    }
}
