package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.service.IRoadService;
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
@RequestMapping("/road")
public class RoadController {

    private final IRoadService roadServiceImpl;

    public RoadController(IRoadService roadServiceImpl) {
        this.roadServiceImpl = roadServiceImpl;
    }

    @GetMapping("findAllByRoadName/{roadName}")
    public ResponseResult findAllByRoadName(@PathVariable("roadName") String roadName) {

        List<Road> list = roadServiceImpl.findAllByRoadName(roadName);
        return ResponseResult.ok(list);
    }
}
