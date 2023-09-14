package com.woniuxy.inspector.service;

import com.woniuxy.inspector.entity.Parking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.inspector.vo.ParkingVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
public interface IParkingService extends IService<Parking> {

    List<ParkingVO>find();
}
