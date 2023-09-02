package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.OperationLog;
import com.woniuxy.operator.mapper.OperationLogMapper;
import com.woniuxy.operator.service.IOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

    private final OperationLogMapper operationLogMapper;

    public OperationLogServiceImpl(OperationLogMapper operationLogMapper){
        this.operationLogMapper = operationLogMapper;
    }

}
