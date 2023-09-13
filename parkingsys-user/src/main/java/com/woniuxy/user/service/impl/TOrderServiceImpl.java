package com.woniuxy.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.woniuxy.user.entity.MagnetometerLog;
import com.woniuxy.user.entity.Parking;
import com.woniuxy.user.entity.TOrder;
import com.woniuxy.user.mapper.MagnetometerLogMapper;
import com.woniuxy.user.mapper.ParkingMapper;
import com.woniuxy.user.mapper.TOrderMapper;
import com.woniuxy.user.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    private final TOrderMapper tOrderMapper;

    private final ParkingMapper parkingMapper;

    private final MagnetometerLogMapper magnetometerLogMapper;

    public TOrderServiceImpl(TOrderMapper tOrderMapper, ParkingMapper parkingMapper, MagnetometerLogMapper magnetometerLogMapper){
        this.tOrderMapper = tOrderMapper;
        this.parkingMapper = parkingMapper;
        this.magnetometerLogMapper = magnetometerLogMapper;
    }

    @Override
    public void createOrder(String parkingNum,Long carId) {
        //通过parkingNum查询路段id,parkingId
        Parking park = parkingMapper.selectOne(Wrappers.lambdaQuery(Parking.class).eq(Parking::getNumber, parkingNum));
        Long roadId = park.getRoadId();
        Long parkingId = park.getId();
        Long magnetometerId = park.getMagnetometerId();
        MagnetometerLog magnetometerLog = magnetometerLogMapper.selectOne(Wrappers.lambdaQuery(MagnetometerLog.class)
                .eq(MagnetometerLog::getMagnetometerId, magnetometerId)
                .orderByAsc(MagnetometerLog::getId)
                .last("LIMIT 1"));
        Date magnetometerLogCreateTime = magnetometerLog.getCreateTime();

        TOrder order=new TOrder();
        order.setCarId(carId);
        order.setRoadId(roadId);
        order.setStatus(1);
        order.setParkingId(parkingId);
        order.setCreateTime(magnetometerLogCreateTime);
        tOrderMapper.insert(order);
    }


}
