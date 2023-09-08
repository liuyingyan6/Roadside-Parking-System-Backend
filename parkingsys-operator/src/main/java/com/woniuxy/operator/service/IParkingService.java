package com.woniuxy.operator.service;

import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.dto.RoadDTO;
import com.woniuxy.operator.entity.Parking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.PageVO;

import java.util.List;


public interface IParkingService extends IService<Parking> {
    int parkingCount(Integer id);
    PageVO<ParkingDTO> findByPage(Integer current, Integer size, ParkingDTO parkingDTO);
}
