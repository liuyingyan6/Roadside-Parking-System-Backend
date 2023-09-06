package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.annotation.SaveOperationLog;
import com.woniuxy.operator.entity.Role;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.woniuxy.operator.entity.LoginLog;
import com.woniuxy.operator.service.ILoginLogService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/login-log")
public class LoginLogController {

    private final ILoginLogService loginLogServiceImpl;

    public LoginLogController(ILoginLogService loginLogServiceImpl) {
        this.loginLogServiceImpl = loginLogServiceImpl;
    }


    @GetMapping("/getPage")
    public ResponseResult getPage(Integer pageNum, Integer pageSize) {
        Page<LoginLog> page = loginLogServiceImpl.page(Page.of(pageNum, pageSize));
        return ResponseResult.ok(page);
    }

    @DeleteMapping("/delete/{id}")
    @SaveOperationLog(description = "登录日志", methodType = "删除")
    public ResponseResult delete(@PathVariable Integer id) {
        return ResponseResult.ok();
    }
}
