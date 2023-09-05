package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.entity.CarVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
public interface ICarService extends IService<Car> {

    Page<CarVO> getCarList(Page<CarVO> page,String key);
}
