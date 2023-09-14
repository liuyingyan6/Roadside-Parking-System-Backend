package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.InspectorFeedback;
import com.woniuxy.inspector.mapper.InspectorFeedbackMapper;
import com.woniuxy.inspector.service.IInspectorFeedbackService;
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
public class InspectorFeedbackServiceImpl extends ServiceImpl<InspectorFeedbackMapper, InspectorFeedback> implements IInspectorFeedbackService {

    private final InspectorFeedbackMapper inspectorFeedbackMapper;

    public InspectorFeedbackServiceImpl(InspectorFeedbackMapper inspectorFeedbackMapper){
        this.inspectorFeedbackMapper = inspectorFeedbackMapper;
    }

}
