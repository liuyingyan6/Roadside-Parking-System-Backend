package com.woniuxy.inspector.controller;

import com.woniuxy.inspector.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/inspectorFeedback")
public class InspectorFeedbackController {

    private final IInspectorFeedbackService inspectorFeedbackServiceImpl;

    public InspectorFeedbackController(IInspectorFeedbackService inspectorFeedbackServiceImpl){
        this.inspectorFeedbackServiceImpl = inspectorFeedbackServiceImpl;
    }
@PostMapping("/add")
    public ResponseResult add(@RequestBody  InspectorFeedback inspectorFeedback){
inspectorFeedbackServiceImpl.save(inspectorFeedback);
        return ResponseResult.ok("提交成功");
}
}
