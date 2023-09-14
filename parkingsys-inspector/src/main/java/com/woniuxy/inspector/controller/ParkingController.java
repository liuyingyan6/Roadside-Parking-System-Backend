package com.woniuxy.inspector.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.inspector.dto.OrderDTO;
import com.woniuxy.inspector.pojos.ResponseResult;
import com.woniuxy.inspector.vo.OrderVO;
import com.woniuxy.inspector.vo.ParkingVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 停车记录
     */
    @GetMapping("/page")
    @ApiOperation("停车记录")
    public ResponseResult page(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize,
                               @Param("orderDto") OrderDTO orderDto) {
//        OrderVO orderVO=new OrderVO();
//        orderVO.setTimeDiff(parkingServiceImpl.getTimeDiff(orderDto.getStartTime(),orderDto.getEndTime()));
//        System.out.println(orderVO);
        PageInfo<OrderVO> pageVO = parkingServiceImpl.findPage(pageNum, pageSize, orderDto);
        return ResponseResult.ok(pageVO);
    }

    /**
     * 泊位管理(查询所有车位)
     */
    @GetMapping("/findAllParking")
    @ApiOperation("泊位查询")
    public ResponseResult findAllParking(){
        return ResponseResult.ok(parkingServiceImpl.list());
    }

    //故障设备远程搜索
    @GetMapping("/find")
    public ResponseResult find(){
        List<ParkingVO> parkingVOS = parkingServiceImpl.find();
        return ResponseResult.ok(parkingVOS);
    }
}
