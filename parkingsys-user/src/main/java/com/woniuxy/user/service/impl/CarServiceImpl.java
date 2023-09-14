package com.woniuxy.user.service.impl;

import com.woniuxy.user.entity.Car;
import com.woniuxy.user.mapper.CarMapper;
import com.woniuxy.user.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.user.vo.CarVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    private final CarMapper carMapper;

    public CarServiceImpl(CarMapper carMapper){
        this.carMapper = carMapper;
    }


}
