package com.woniuxy.operator.service;

import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.entity.Road;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.RoadVO;

import java.util.List;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */

public interface IRoadService extends IService<Road> {

    List<Road> findAllByRoadName(String roadName);
    PageVO<RoadDTO> findByPage(Integer current, Integer size, RoadDTO roadDTO);
    void saveRoad(RoadDTO roadDTO);

    List<RoadVO> findRoad();
}
