package com.woniuxy.operator.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.vo.*;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface OrderMapper extends MPJBaseMapper<Order> {

    List<OrderVO> findAll();

    //自定义分页
    List<OrderVO> findAllPage(@Param("orderDTO") OrderDTO orderDTO);

    List<RevenueVO> selectRevenueInfo(@Param("roadId") String roadId,
                                      @Param("startDate") String startDate,
                                      @Param("endDate") String endDate);

    OrderConversionVO selectOrderConversionVOByKeyword(@Param("roadId") String roadId,
                                                             @Param("startDate") String startDate,
                                                             @Param("endDate") String endDate);

    List<PayDateVO> payDate(@Param("startTime") String startTime,
                            @Param("endTime") String endTime);

    PayCountVO payCount(@Param("startTime") String startTime,
                        @Param("endTime") String endTime);
}
