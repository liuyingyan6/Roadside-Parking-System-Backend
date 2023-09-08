package com.woniuxy.operator.controller;

import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import io.swagger.annotations.ApiOperation;
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

    public ParkingController(IParkingService parkingServiceImpl) {
        this.parkingServiceImpl = parkingServiceImpl;
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
     * 统计车位数
     */
    @GetMapping("/count")
    public int parkingCount(@RequestParam Integer id) {
        return parkingServiceImpl.parkingCount(id);
    }
}
