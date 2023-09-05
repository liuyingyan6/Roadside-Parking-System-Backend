package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.service.IInspectorService;
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
@RequestMapping("/inspector")
public class InspectorController {

    private final IInspectorService inspectorServiceImpl;

    public InspectorController(IInspectorService inspectorServiceImpl){
        this.inspectorServiceImpl = inspectorServiceImpl;
    }

}
