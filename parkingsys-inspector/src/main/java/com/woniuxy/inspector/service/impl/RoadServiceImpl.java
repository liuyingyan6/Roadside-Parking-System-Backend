package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.Road;
import com.woniuxy.inspector.mapper.RoadMapper;
import com.woniuxy.inspector.service.IRoadService;
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
public class RoadServiceImpl extends ServiceImpl<RoadMapper, Road> implements IRoadService {

    private final RoadMapper roadMapper;

    public RoadServiceImpl(RoadMapper roadMapper){
        this.roadMapper = roadMapper;
    }

}
