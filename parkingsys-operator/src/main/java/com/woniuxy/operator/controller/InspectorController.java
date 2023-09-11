package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.InspectorVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.service.IInspectorService;
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
@RequestMapping("/inspector")
public class InspectorController {

    private final IInspectorService inspectorServiceImpl;

    public InspectorController(IInspectorService inspectorServiceImpl) {
        this.inspectorServiceImpl = inspectorServiceImpl;
    }


    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody InspectorDTO inspectorDTO) {

        PageInfo<InspectorVO> page = inspectorServiceImpl.findPage(pageNum, pageSize, inspectorDTO);
        return ResponseResult.ok(page);
    }

    @PostMapping("/saveInspector")
    public ResponseResult saveInspector(@RequestBody InspectorVO inspectorVO) {
        inspectorServiceImpl.saveInspector(inspectorVO);
        return ResponseResult.ok();
    }

    @PutMapping("/updateInspector")
    public ResponseResult updateInspector(@RequestBody InspectorVO inspectorVO) {
        inspectorServiceImpl.updateInspector(inspectorVO);
        return ResponseResult.ok();
    }

    @PutMapping("/updateState")
    public ResponseResult updateState(@RequestBody Inspector inspector) {
        if (inspector.getState()!=1){
            inspector.setState(1);
        }else {
            inspector.setState(0);
        }
        inspectorServiceImpl.updateById(inspector);
        return ResponseResult.ok(inspector.getState());
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseResult deleteById(@PathVariable("id") String id) {
        inspectorServiceImpl.deleteById(id);
        return ResponseResult.ok();
    }

    @GetMapping("/list")
    public ResponseResult list() {
        List<Inspector> list = inspectorServiceImpl.list();
        return ResponseResult.ok(list);
    }
}
