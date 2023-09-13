package com.woniuxy.operator.controller;

import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.vo.PageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
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
