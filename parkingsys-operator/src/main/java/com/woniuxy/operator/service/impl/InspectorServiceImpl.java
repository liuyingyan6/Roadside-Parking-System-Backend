package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.mapper.InspectorMapper;
import com.woniuxy.operator.service.IInspectorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class InspectorServiceImpl extends ServiceImpl<InspectorMapper, Inspector> implements IInspectorService {

    private final InspectorMapper inspectorMapper;

    public InspectorServiceImpl(InspectorMapper inspectorMapper){
        this.inspectorMapper = inspectorMapper;
    }

}
