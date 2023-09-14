package com.woniuxy.operator.controller;

import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.entity.Magnetometer;

import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.service.IMagnetometerService;
import com.woniuxy.operator.vo.PageVO;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.service.IParkingService;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final IParkingService parkingServiceImpl;
    private final IMagnetometerService magnetometerServiceImpl;

    public ParkingController(IParkingService parkingServiceImpl, IMagnetometerService magnetometerServiceImpl) {
        this.parkingServiceImpl = parkingServiceImpl;
        this.magnetometerServiceImpl = magnetometerServiceImpl;
    }

    /**
     * 分页查询
     */
    @PostMapping("/page/{pageNum}/{pageSize}")
    @ApiOperation("分页查询")
    public ResponseResult findByPage(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody ParkingDTO parkingDTO) {
        PageVO<ParkingDTO> pageVO = parkingServiceImpl.findByPage(pageNum, pageSize, parkingDTO);
        return ResponseResult.ok(pageVO);
    }

    /**
     * 连表添加
     */
    @PutMapping("/saveOrUpdate")
    public ResponseResult saveOrUpdate(@RequestBody ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        Magnetometer magnetometer = new Magnetometer();

        BeanUtils.copyProperties(parkingDTO, parking);
        parkingServiceImpl.saveOrUpdate(parking);

        BeanUtils.copyProperties(parkingDTO, magnetometer);
        // 从parking对象中获取生成的ID，并放到magnetometer对象中
        magnetometer.setParkingId(parking.getId());
        magnetometer.setName(parkingDTO.getMagnetometerName());
        magnetometerServiceImpl.saveOrUpdate(magnetometer);

        // 从magnetometer对象中获取生成的ID，并设置回parking对象中
        parking.setMagnetometerId(magnetometer.getId());
        // 更新parking对象
        parkingServiceImpl.saveOrUpdate(parking);

        return ResponseResult.ok();
    }

    /**
     * 连表编辑
     */
    @PutMapping("/update")
    public ResponseResult updatePark(@RequestBody ParkingDTO parkingDTO) {
        parkingServiceImpl.updatePark(parkingDTO);
        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id") Long id) {
        parkingServiceImpl.removeById(id);
        return ResponseResult.ok();
    }

    /**
     * 统计车位数
     */
    @GetMapping("/count")
    public int parkingCount(@RequestParam Integer id) {
        return parkingServiceImpl.parkingCount(id);
    }
}
