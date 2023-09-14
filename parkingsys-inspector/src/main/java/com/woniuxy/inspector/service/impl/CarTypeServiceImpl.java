package com.woniuxy.inspector.service.impl;

import com.woniuxy.inspector.entity.CarType;
import com.woniuxy.inspector.mapper.CarTypeMapper;
import com.woniuxy.inspector.service.ICarTypeService;
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
public class CarTypeServiceImpl extends ServiceImpl<CarTypeMapper, CarType> implements ICarTypeService {

    private final CarTypeMapper carTypeMapper;

    public CarTypeServiceImpl(CarTypeMapper carTypeMapper){
        this.carTypeMapper = carTypeMapper;
    }

}
