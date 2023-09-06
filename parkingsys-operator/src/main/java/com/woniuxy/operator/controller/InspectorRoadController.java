package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.InspectorRoad;
import com.woniuxy.operator.service.IInspectorRoadService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-06
 */
@RestController
@RequestMapping("/inspector-road")
public class InspectorRoadController {

    private final IInspectorRoadService inspectorRoadServiceImpl;

    public InspectorRoadController(IInspectorRoadService inspectorRoadServiceImpl){
        this.inspectorRoadServiceImpl = inspectorRoadServiceImpl;
    }

}
