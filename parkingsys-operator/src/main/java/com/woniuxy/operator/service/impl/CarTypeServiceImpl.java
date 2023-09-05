package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.CarType;
import com.woniuxy.operator.mapper.CarTypeMapper;
import com.woniuxy.operator.service.ICarTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeMapper, CarType> implements ICarTypeService {

    private final CarTypeMapper carTypeMapper;

    public CarTypeServiceImpl(CarTypeMapper carTypeMapper){
        this.carTypeMapper = carTypeMapper;
    }

}
