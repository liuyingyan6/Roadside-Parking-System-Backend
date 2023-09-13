package com.woniuxy.inspector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.inspector.entity.InspectorFeedback;
import com.woniuxy.inspector.service.IInspectorFeedbackService;
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
@RequestMapping("/inspector-feedback")
public class InspectorFeedbackController {

    private final IInspectorFeedbackService inspectorFeedbackServiceImpl;

    public InspectorFeedbackController(IInspectorFeedbackService inspectorFeedbackServiceImpl){
        this.inspectorFeedbackServiceImpl = inspectorFeedbackServiceImpl;
    }

}
