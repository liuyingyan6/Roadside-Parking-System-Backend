package com.woniuxy.operator.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.vo.OrderConversionVO;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.RoadOrderVO;
import com.woniuxy.operator.vo.RevenueVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public interface OrderMapper extends BaseMapper<Order> {

    List<OrderVO> findAll();

    //自定义分页
    List<OrderVO> findAllPage(@Param("orderDTO") OrderDTO orderDTO);

    List<RevenueVO> selectRevenueInfo(@Param("roadId") String roadId,
                                      @Param("startDate") String startDate,
                                      @Param("endDate") String endDate);

    OrderConversionVO selectOrderConversionVOByKeyword(@Param("roadId") String roadId,
                                                             @Param("startDate") String startDate,
                                                             @Param("endDate") String endDate);

    List<RoadOrderVO> getRoadOrderList(@Param("roadId") Integer roadId);

    BigDecimal getPayAmount(@Param("createTime") LocalDate createTime,@Param("roadId") Integer roadId);

    RoadOrderVO getRefund(@Param("createTime") LocalDate createTime,@Param("roadId") Integer roadId);

    RoadOrderVO getAbnormal(@Param("createTime") LocalDate createTime,@Param("roadId") Integer roadId);

    Integer getPayCount(@Param("createTime") LocalDate createTime,@Param("roadId") Integer roadId);
}
