package com.woniuxy.user.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.user.entity.TOrder;
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
public interface TOrderMapper extends BaseMapper<TOrder> {
List<OrderVO> findOrder(String carNumber);
}
