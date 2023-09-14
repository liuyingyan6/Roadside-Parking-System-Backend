package com.woniuxy.inspector.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.inspector.dto.OrderDTO;
import com.woniuxy.inspector.entity.Parking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.inspector.vo.OrderVO;
import com.woniuxy.inspector.vo.ParkingVO;

import java.util.Date;
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

    int parkingCount(Integer id);

    PageInfo<OrderVO> findPage(Integer pageNum, Integer pageSize, OrderDTO orderDto);

    String getTimeDiff(Date createTime, Date updateTime);

    List<ParkingVO>find();
}
