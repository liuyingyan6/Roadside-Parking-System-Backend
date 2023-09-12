package com.woniuxy.operator.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.UserFeedbackVO;
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
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/userFeedback")
public class UserFeedbackController {

    private final IUserFeedbackService userFeedbackServiceImpl;

    public UserFeedbackController(IUserFeedbackService userFeedbackServiceImpl){
        this.userFeedbackServiceImpl = userFeedbackServiceImpl;
    }
    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            @RequestBody UserDTO userDTO) {

        PageInfo<UserFeedbackVO> page = userFeedbackServiceImpl.findPage(pageNum, pageSize, userDTO);
        return ResponseResult.ok(page);
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody UserFeedback userFeedback) {
        userFeedback.setState(1);
        if (userFeedback.getResult() == null) {
            userFeedback.setResult("无");
        }
        userFeedbackServiceImpl.saveOrUpdate(userFeedback);
        return ResponseResult.ok();
    }
}
