package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.InspectorRoad;
import com.woniuxy.operator.mapper.InspectorRoadMapper;
import com.woniuxy.operator.service.IInspectorRoadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-06
 */
@Service
public class InspectorRoadServiceImpl extends ServiceImpl<InspectorRoadMapper, InspectorRoad> implements IInspectorRoadService {

    private final InspectorRoadMapper inspectorRoadMapper;

    public InspectorRoadServiceImpl(InspectorRoadMapper inspectorRoadMapper){
        this.inspectorRoadMapper = inspectorRoadMapper;
    }

}
