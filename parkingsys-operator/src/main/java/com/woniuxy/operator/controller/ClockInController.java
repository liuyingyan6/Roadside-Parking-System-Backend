package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.ClockInDTO;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.ClockInVO;
import com.woniuxy.operator.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.ClockIn;
import com.woniuxy.operator.service.IClockInService;
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
@RequestMapping("/clockIn")
public class ClockInController {

    private final IClockInService clockInServiceImpl;

    public ClockInController(IClockInService clockInServiceImpl) {
        this.clockInServiceImpl = clockInServiceImpl;
    }

    @GetMapping("/page")
    public ResponseResult page(@Param("pageNum") Integer pageNum,
                               @Param("pageSize") Integer pageSize,
                               @Param("orderDto") ClockInDTO clockInDTO) {
        //封装分页请求对象
        PageInfo<ClockInVO> pageVO = clockInServiceImpl.findPage(pageNum, pageSize, clockInDTO);
        return ResponseResult.ok(pageVO);
    }

}
