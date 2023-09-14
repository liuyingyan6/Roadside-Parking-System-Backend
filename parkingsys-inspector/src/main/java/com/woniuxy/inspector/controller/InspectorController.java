package com.woniuxy.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.inspector.entity.Inspector;
import com.woniuxy.inspector.service.IInspectorService;
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
@RequestMapping("/inspector")
public class InspectorController {

    private final IInspectorService inspectorServiceImpl;

    public InspectorController(IInspectorService inspectorServiceImpl){
        this.inspectorServiceImpl = inspectorServiceImpl;
    }

}
