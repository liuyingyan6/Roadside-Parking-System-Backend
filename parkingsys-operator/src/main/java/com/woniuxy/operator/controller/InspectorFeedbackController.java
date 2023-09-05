package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.InspectorFeedback;
import com.woniuxy.operator.service.IInspectorFeedbackService;
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
@RequestMapping("/inspector-feedback")
public class InspectorFeedbackController {

    private final IInspectorFeedbackService inspectorFeedbackServiceImpl;

    public InspectorFeedbackController(IInspectorFeedbackService inspectorFeedbackServiceImpl){
        this.inspectorFeedbackServiceImpl = inspectorFeedbackServiceImpl;
    }

}
