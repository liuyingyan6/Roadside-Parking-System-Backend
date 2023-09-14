package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.*;

import java.util.Date;
import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IOrderService extends IService<Order> {

    List<OrderVO> findAll();

    PageInfo<OrderVO> findPage(Integer pageNum, Integer pageSize, OrderDTO orderDto);

    CountOrderVO countOrder(String startTime, String endTime, Integer pageNum, Integer pageSize);

    List<RevenueVO> getRevenueInfo(String roadId, String startDate, String endDate);

    OrderConversionVO getOrderConversionVOByKeyword(String roadId, String startDate, String endDate);

    OrderConversionVO orderStatusCount(String inspectorId);

    PageInfo<OrderVO> findAllByInspectorId(Integer pageNum, Integer pageSize, String inspectorId, OrderDTO orderDto);

    PageInfo<OrderVO> findAll2ByInspectorId(Integer pageNum, Integer pageSize, String inspectorId, OrderDTO orderDto);

    List<PayDateVO> payDate(String startTime, String endTime);

    PayCountVO payCount(String startTime, String endTime);

    List<RoadOrderVO> getRoadOrderList(Integer roadId);
}
