package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.Parking;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IParkingService extends IService<Parking> {
    int parkingCount(Integer id);
}
