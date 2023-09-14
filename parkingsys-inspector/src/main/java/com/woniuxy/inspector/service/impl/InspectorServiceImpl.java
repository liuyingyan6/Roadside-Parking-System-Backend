package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.Inspector;
import com.woniuxy.inspector.mapper.InspectorMapper;
import com.woniuxy.inspector.service.IInspectorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class InspectorServiceImpl extends ServiceImpl<InspectorMapper, Inspector> implements IInspectorService {

    private final InspectorMapper inspectorMapper;

    public InspectorServiceImpl(InspectorMapper inspectorMapper){
        this.inspectorMapper = inspectorMapper;
    }

}
