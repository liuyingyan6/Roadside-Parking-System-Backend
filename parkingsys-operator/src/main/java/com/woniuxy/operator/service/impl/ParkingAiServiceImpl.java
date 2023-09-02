package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.ParkingAi;
import com.woniuxy.operator.mapper.ParkingAiMapper;
import com.woniuxy.operator.service.IParkingAiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Service
public class ParkingAiServiceImpl extends ServiceImpl<ParkingAiMapper, ParkingAi> implements IParkingAiService {

    private final ParkingAiMapper parkingAiMapper;

    public ParkingAiServiceImpl(ParkingAiMapper parkingAiMapper){
        this.parkingAiMapper = parkingAiMapper;
    }

}
