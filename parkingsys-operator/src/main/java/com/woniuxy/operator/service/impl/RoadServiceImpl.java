package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.operator.entity.InspectorRoad;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IRoadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.InspectorRoadVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class RoadServiceImpl extends ServiceImpl<RoadMapper, Road> implements IRoadService {

    private final RoadMapper roadMapper;

    public RoadServiceImpl(RoadMapper roadMapper){
        this.roadMapper = roadMapper;
    }

    @Override
    public List<Road> findAllByRoadName(String roadName) {
        MPJLambdaWrapper<Road> wrapper = new MPJLambdaWrapper<Road>()
                .selectAll(Road.class)//查询InspectorRoad表全部字段
                .likeRight(StringUtils.hasLength(roadName), Road::getRoadName, roadName);
        List<Road> roads = roadMapper.selectList(wrapper);
        return roads;
    }
}
