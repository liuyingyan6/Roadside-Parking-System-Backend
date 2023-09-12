package com.woniuxy.operator.controller;

import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import com.woniuxy.operator.service.IRoadService;
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
@RequestMapping("/road")
public class RoadController {

    private final IRoadService roadServiceImpl;

    public RoadController(IRoadService roadServiceImpl) {
        this.roadServiceImpl = roadServiceImpl;
    }

    /**
     * 分页查询
     */
    @PostMapping("/page/{pageNum}/{pageSize}")
    @ApiOperation("分页查询")
    public ResponseResult findByPage(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody RoadDTO roadDTO) {
        PageVO<RoadDTO> pageVO = roadServiceImpl.findByPage(pageNum, pageSize, roadDTO);
        return ResponseResult.ok(pageVO);
    }

    /**
     * 新建
     */
    @PostMapping("/add")
    public ResponseResult addRoad(@RequestBody Road road) {
        roadServiceImpl.save(road);
        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除信息")
    public ResponseResult deleteRoad(@PathVariable("id") Long id) {
        roadServiceImpl.removeById(id);
        return ResponseResult.ok();
    }

    /**
     * 禁用功能
     */
    @PutMapping("/update")
    public ResponseResult update(@RequestBody Road road){
        Integer num;
        if (road.getState()!=1){
            road.setState(1);
            num=1;
        }else {
            road.setState(0);
            num=0;
        }
        roadServiceImpl.updateById(road);
        return ResponseResult.ok(road.getState());
    }

    @GetMapping("/list")
    public ResponseResult list(){
        return ResponseResult.ok(roadServiceImpl.list());
    }
}
