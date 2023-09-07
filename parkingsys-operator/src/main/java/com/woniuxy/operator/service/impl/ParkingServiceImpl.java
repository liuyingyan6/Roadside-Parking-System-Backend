package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.operator.entity.Parking;
import com.woniuxy.operator.mapper.ParkingMapper;
import com.woniuxy.operator.service.IParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    private final ParkingMapper parkingMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper){
        this.parkingMapper = parkingMapper;
    }

    /**
     * 统计车位数
     */
    @Override
    public int parkingCount(Integer id) {
        QueryWrapper<Parking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        int count = parkingMapper.selectCount(queryWrapper).intValue();
        return count;
    }


}
