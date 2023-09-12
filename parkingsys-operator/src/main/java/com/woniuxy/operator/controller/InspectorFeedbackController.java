package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.InspectorFeedbackDetailVO;
import com.woniuxy.operator.vo.InspectorFeedbackVO;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/inspectorFeedback")
public class InspectorFeedbackController {

    private final IInspectorFeedbackService inspectorFeedbackServiceImpl;

    public InspectorFeedbackController(IInspectorFeedbackService inspectorFeedbackServiceImpl){
        this.inspectorFeedbackServiceImpl = inspectorFeedbackServiceImpl;
    }


    @GetMapping("/inspectorFeedbackList")
    public ResponseResult getDetail(Integer feedbackId){
        System.out.println("feedbackId=========="+feedbackId);
        System.out.println("getClass=========="+feedbackId.getClass());
        InspectorFeedbackDetailVO detailVO = inspectorFeedbackServiceImpl.findDetail(feedbackId);
        return ResponseResult.ok(detailVO);
    }

    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(@PathVariable("pageNum") Integer pageNum,
                                   @PathVariable("pageSize") Integer pageSize,
                                   @RequestBody InspectorDTO inspectorDTO){
        PageInfo<InspectorFeedbackVO> page = inspectorFeedbackServiceImpl.findPage(pageNum,pageSize,inspectorDTO);
        return ResponseResult.ok(page);
    }

    @PostMapping("/handleFeedback/{fId}/{information}")
    public ResponseResult handleFeedback(@PathVariable("fId") Integer fId,
                                         @PathVariable String information) {

        System.out.println("information============"+information);
        System.out.println("getClass============"+information.getClass());

        inspectorFeedbackServiceImpl.saveFeedback(fId,information);
        return ResponseResult.ok();
    }
}
