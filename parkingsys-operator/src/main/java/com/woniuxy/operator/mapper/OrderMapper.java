package com.woniuxy.operator.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.RevenueVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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

    List<RevenueVO> selectRevenueInfo();
}
