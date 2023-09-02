package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.UserFeedback;
import com.woniuxy.operator.service.IUserFeedbackService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@RestController
@RequestMapping("/user-feedback")
public class UserFeedbackController {

    private final IUserFeedbackService userFeedbackServiceImpl;

    public UserFeedbackController(IUserFeedbackService userFeedbackServiceImpl){
        this.userFeedbackServiceImpl = userFeedbackServiceImpl;
    }

}
