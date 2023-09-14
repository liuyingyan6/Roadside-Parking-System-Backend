package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.Car;
import com.woniuxy.inspector.mapper.CarMapper;
import com.woniuxy.inspector.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    private final CarMapper carMapper;

    public CarServiceImpl(CarMapper carMapper){
        this.carMapper = carMapper;
    }

}
