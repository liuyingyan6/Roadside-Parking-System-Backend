package com.woniuxy.user.controller;

import com.woniuxy.user.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.user.entity.UserFeedback;
import com.woniuxy.user.service.IUserFeedbackService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/userFeedback")
public class UserFeedbackController {

    private final IUserFeedbackService userFeedbackServiceImpl;

    public UserFeedbackController(IUserFeedbackService userFeedbackServiceImpl){
        this.userFeedbackServiceImpl = userFeedbackServiceImpl;
    }
    //意见反馈
    @PostMapping("/add")
    public ResponseResult add(@RequestBody UserFeedback userFeedback){
        userFeedbackServiceImpl.save(userFeedback);
        return ResponseResult.ok("提交成功");
    }

}
