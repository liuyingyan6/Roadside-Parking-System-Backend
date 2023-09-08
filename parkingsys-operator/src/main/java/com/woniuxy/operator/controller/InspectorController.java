package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Information;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.InspectorVO;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/list")
    public ResponseResult list(){
        List<Inspector> list = inspectorServiceImpl.list();
        return ResponseResult.ok(list);
    }
}
