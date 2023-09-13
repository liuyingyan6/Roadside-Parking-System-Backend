package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.InspectorVO;
import com.woniuxy.operator.vo.PageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.service.IInspectorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inspector")
public class InspectorController {

    private final IInspectorService inspectorServiceImpl;

    public InspectorController(IInspectorService inspectorServiceImpl) {
        this.inspectorServiceImpl = inspectorServiceImpl;
    }

    @GetMapping("/findAll")
    @ApiOperation("查询所有巡检员")
    public ResponseResult findAll(){
        return ResponseResult.ok(inspectorServiceImpl.list());
    }

    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody InspectorDTO inspectorDTO) {

        PageInfo<InspectorVO> page = inspectorServiceImpl.findPage(pageNum, pageSize, inspectorDTO);
        return ResponseResult.ok(page);
    }

    /**
     * 模糊查询
     */
    @GetMapping("/findByInspectorName")
    public List<Inspector>findByInspectorName(@RequestParam String inspectorName){
        return inspectorServiceImpl.findByInspectorName(inspectorName);
    }

}
