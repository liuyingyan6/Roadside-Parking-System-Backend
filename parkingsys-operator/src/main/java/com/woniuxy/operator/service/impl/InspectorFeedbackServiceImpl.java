package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.InspectorFeedback;
import com.woniuxy.operator.mapper.InspectorFeedbackMapper;
import com.woniuxy.operator.service.IInspectorFeedbackService;
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
public class InspectorFeedbackServiceImpl extends ServiceImpl<InspectorFeedbackMapper, InspectorFeedback> implements IInspectorFeedbackService {

    private final InspectorFeedbackMapper inspectorFeedbackMapper;

    public InspectorFeedbackServiceImpl(InspectorFeedbackMapper inspectorFeedbackMapper){
        this.inspectorFeedbackMapper = inspectorFeedbackMapper;
    }

}
