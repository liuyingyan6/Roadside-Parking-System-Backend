package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.ClockInDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.ClockInVO;
import com.woniuxy.operator.vo.PageVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.ClockIn;
import com.woniuxy.operator.service.IClockInService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/clockIn")
public class ClockInController {

    private final IClockInService clockInServiceImpl;

    public ClockInController(IClockInService clockInServiceImpl) {
        this.clockInServiceImpl = clockInServiceImpl;
    }

    @PostMapping("/page/{pageNum}/{pageSize}")
    public ResponseResult page(@PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize,
                               @RequestBody ClockInDTO clockInDTO) {
        //封装分页请求对象
        PageVO<ClockInVO> pageVO = clockInServiceImpl.findPage(pageNum, pageSize, clockInDTO);
        return ResponseResult.ok(pageVO);
    }


    @GetMapping("/findByInspectorId/{inspectorId}/{month}")
    public ResponseResult findByInspectorId(@PathVariable("inspectorId") String inspectorId,@PathVariable("month") String month) {
        List<ClockIn> clockInList = clockInServiceImpl.findByInspetorId(inspectorId,month);
        return ResponseResult.ok(clockInList);
    }

    @GetMapping("/findByInspectorIdCount/{inspectorId}/{month}")
    public ResponseResult findByInspectorIdCount(@PathVariable("inspectorId") String inspectorId,@PathVariable("month") String month) {
        ClockInVO clockInVO = clockInServiceImpl.findByInspectorIdCount(inspectorId,month);
        return ResponseResult.ok(clockInVO);
    }

}
