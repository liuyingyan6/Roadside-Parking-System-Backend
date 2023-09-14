package com.woniuxy.user.mapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.user.entity.Order;
import com.woniuxy.user.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Mapper
public interface OrderMapper extends MPJBaseMapper<Order> {
List<OrderVO> findOrder(String carNumber);

}
