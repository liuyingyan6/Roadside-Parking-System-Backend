package com.woniuxy.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.inspector.entity.Road;
import com.woniuxy.inspector.service.IRoadService;
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
@RequestMapping("/road")
public class RoadController {

    private final IRoadService roadServiceImpl;

    public RoadController(IRoadService roadServiceImpl){
        this.roadServiceImpl = roadServiceImpl;
    }

}
