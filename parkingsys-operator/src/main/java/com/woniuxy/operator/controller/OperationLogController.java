package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.LoginLog;
import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.OperationLog;
import com.woniuxy.operator.service.IOperationLogService;
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
@RequestMapping("/operationLog")
public class OperationLogController {

    private final IOperationLogService operationLogServiceImpl;

    public OperationLogController(IOperationLogService operationLogServiceImpl){
        this.operationLogServiceImpl = operationLogServiceImpl;
    }

    @GetMapping("/getPage")
    public ResponseResult getPage(Integer pageNum, Integer pageSize) {
        Page<OperationLog> page = operationLogServiceImpl.page(Page.of(pageNum, pageSize));
        return ResponseResult.ok(page);
    }

}
