package com.woniuxy.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.user.entity.Parking;
import com.woniuxy.user.mapper.ParkingMapper;
import com.woniuxy.user.service.IParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    private final ParkingMapper parkingMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper){
        this.parkingMapper = parkingMapper;
    }

    @Override
    public Long getParkingStatus(String parkingNum) {
        Parking park = parkingMapper.selectOne(Wrappers.lambdaQuery(Parking.class)
                .eq(Parking::getNumber, parkingNum));
        Long status = park.getStatus();
        return status;
    }
}
