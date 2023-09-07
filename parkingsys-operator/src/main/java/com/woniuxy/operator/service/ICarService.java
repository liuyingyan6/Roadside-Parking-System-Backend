package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.CarVO;
import com.woniuxy.operator.vo.CarOrderVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface ICarService extends IService<Car> {


    List<CarVO> getAll(String key);

    List<CarOrderVO> getCarOrderList(String carNumber);

    void liftCar(Integer carId,Integer userId);

    Car getCarInfo(String carNumber);
}
