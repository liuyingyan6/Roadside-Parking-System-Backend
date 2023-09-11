package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IRoadService;
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

    @Override
    public List<RoadVO> findRoad() {

        List<RoadVO> roads = roadMapper.selectRoad();
        return roads;
    }
}
