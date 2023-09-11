package com.woniuxy.operator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.FeedbackImg;
import com.woniuxy.operator.service.IFeedbackImgService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-10
 */
@RestController
@RequestMapping("/feedback-img")
public class FeedbackImgController {

    private final IFeedbackImgService feedbackImgServiceImpl;

    public FeedbackImgController(IFeedbackImgService feedbackImgServiceImpl){
        this.feedbackImgServiceImpl = feedbackImgServiceImpl;
    }

}
