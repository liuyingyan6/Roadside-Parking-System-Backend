package com.woniuxy.operator.controller;

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
 * @since 2023-09-02
 */
@RestController
@RequestMapping("/operation-log")
public class OperationLogController {

    private final IOperationLogService operationLogServiceImpl;

    public OperationLogController(IOperationLogService operationLogServiceImpl){
        this.operationLogServiceImpl = operationLogServiceImpl;
    }

}
