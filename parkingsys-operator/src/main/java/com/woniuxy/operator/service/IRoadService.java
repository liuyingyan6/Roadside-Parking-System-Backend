package com.woniuxy.operator.service;

import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.entity.Road;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;


public interface IRoadService extends IService<Road> {

    PageVO<RoadDTO> findByPage(Integer current, Integer size, RoadDTO roadDTO);

    void saveRoad(RoadDTO roadDTO);
}
