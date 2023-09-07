package com.woniuxy.operator.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IRoadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoadServiceImpl extends ServiceImpl<RoadMapper, Road> implements IRoadService {

    private final RoadMapper roadMapper;

    public RoadServiceImpl(RoadMapper roadMapper){
        this.roadMapper = roadMapper;
    }

    @Override
    public PageVO findByPage(Integer current, Integer size, RoadDTO roadDTO) {
        IPage iPage=new Page<>(current,size);

        String name = roadDTO.getName();
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
}
