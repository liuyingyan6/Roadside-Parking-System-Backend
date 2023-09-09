package com.woniuxy.operator.controller;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InformationDTO;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.InspectorFeedbackVO;
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
@RequestMapping("/inspectorFeedback")
public class InspectorFeedbackController {

    private final IInspectorFeedbackService inspectorFeedbackServiceImpl;

    public InspectorFeedbackController(IInspectorFeedbackService inspectorFeedbackServiceImpl){
        this.inspectorFeedbackServiceImpl = inspectorFeedbackServiceImpl;
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
