package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.entity.Road;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.RoadVO;

import java.util.List;
import java.util.Map;


public interface IRoadService extends IService<Road> {
    PageVO<RoadDTO> selectRoadDTOPage(Integer pageNum, Integer pageSize, RoadDTO roadDTO);
    void saveRoad(RoadDTO roadDTO);
    void updateByRoadType(Road road);

    List<RoadVO> findRoad();

    List<Road> findAllByRoadName(String roadName);
}
