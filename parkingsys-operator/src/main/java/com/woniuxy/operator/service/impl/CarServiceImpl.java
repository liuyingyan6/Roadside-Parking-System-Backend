package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Car;
import com.woniuxy.operator.mapper.CarMapper;
import com.woniuxy.operator.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.CarVO;
import com.woniuxy.operator.vo.CarOrderVO;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CarOrderVO> getCarOrderList(String carNumber) {
        List<CarOrderVO> carOrderList = carMapper.getCarOrderList(carNumber);
        return carOrderList;
    }

    @Override
    public void liftCar(Integer carId,Integer userId) {
        carMapper.liftCar(carId);
        carMapper.liftUser(userId);
    }

    @Override
    public Car getCarInfo(String carNumber) {
       Car car= carMapper.getCarInfo(carNumber);
        return car;
    }
}
