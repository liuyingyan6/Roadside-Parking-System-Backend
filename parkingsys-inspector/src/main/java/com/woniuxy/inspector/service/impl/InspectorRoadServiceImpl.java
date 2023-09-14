package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.InspectorRoad;
import com.woniuxy.inspector.mapper.InspectorRoadMapper;
import com.woniuxy.inspector.service.IInspectorRoadService;
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
public class InspectorRoadServiceImpl extends ServiceImpl<InspectorRoadMapper, InspectorRoad> implements IInspectorRoadService {

    private final InspectorRoadMapper inspectorRoadMapper;

    public InspectorRoadServiceImpl(InspectorRoadMapper inspectorRoadMapper){
        this.inspectorRoadMapper = inspectorRoadMapper;
    }

}
