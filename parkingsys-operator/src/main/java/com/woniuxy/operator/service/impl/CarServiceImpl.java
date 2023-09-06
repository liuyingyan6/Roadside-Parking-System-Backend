package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.mapper.CarMapper;
import com.woniuxy.operator.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.entity.CarVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    private final CarMapper carMapper;

    public CarServiceImpl(CarMapper carMapper){
        this.carMapper = carMapper;
    }



    @Override
    public List<CarVO> getAll(String key){
        List<CarVO> list = carMapper.getCar(key);
        list.forEach(e->{
            Integer orderCount = carMapper.getCarOrderCount(e.getCarNumber());
            e.setOrderCount(orderCount);
            BigDecimal notPayAmount = carMapper.getNotPayAmount(e.getCarNumber());
            e.setNotPayAmount(notPayAmount);
            Integer notPayCount = carMapper.getNotPayCount(e.getCarNumber());
            e.setNotPayCount(notPayCount);
            BigDecimal payAmount = carMapper.getPayAmount(e.getCarNumber());
            e.setOrderAmount(payAmount);
        });
        return list;

    }
}
