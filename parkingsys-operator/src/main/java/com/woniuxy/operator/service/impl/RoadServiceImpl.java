package com.woniuxy.operator.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IRoadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.RoadVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoadServiceImpl extends ServiceImpl<RoadMapper, Road> implements IRoadService {

    private final RoadMapper roadMapper;

    public RoadServiceImpl(RoadMapper roadMapper){
        this.roadMapper = roadMapper;
    }

    @Override
    public PageVO selectRoadDTOPage(Integer current, Integer size, RoadDTO roadDTO) {
        IPage iPage=new Page<>(current,size);

        String name = roadDTO.getRoadName();
        String chargingRule=roadDTO.getChargingRule();
        String inspectorName = roadDTO.getInspectorName();

        IPage<RoadDTO> page = baseMapper.selectRoadDTOPage(iPage, name, chargingRule, inspectorName);

        return PageVO.<RoadDTO>builder()
                .records(page.getRecords())
                .total(page.getTotal())
                .build();
    }

    @Override
    public void saveRoad(RoadDTO roadDTO) {
        //拷贝属性
        Road road = BeanUtil.copyProperties(roadDTO, Road.class);
        road.setCreateTime(new Date());
        roadMapper.insert(road);
    }

    @Override
    @Transactional
    public void updateByRoadType(Road road) {
        roadMapper.updateById(road);
    }

    @Override
    public List<Road> findByRoadName(String roadName) {
        //查询InspectorRoad表全部字段
        MPJLambdaWrapper<Road> wrapper = new MPJLambdaWrapper<Road>()
                .selectAll(Road.class)
                .likeRight(StringUtils.hasLength(roadName), Road::getRoadName, roadName);
        List<Road> roads = roadMapper.selectList(wrapper);
        return roads;
    }

    @Override
    public List<RoadVO> findRoad() {
        List<RoadVO> roads = roadMapper.selectRoad();
        return roads;
    }
}
