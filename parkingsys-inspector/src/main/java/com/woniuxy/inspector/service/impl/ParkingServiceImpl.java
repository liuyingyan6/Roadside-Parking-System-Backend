package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.Parking;
import com.woniuxy.inspector.mapper.ParkingMapper;
import com.woniuxy.inspector.service.IParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.inspector.vo.ParkingVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    private final ParkingMapper parkingMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper){
        this.parkingMapper = parkingMapper;
    }

    @Override
    public List<ParkingVO> find() {

        return parkingMapper.find();
    }
}
