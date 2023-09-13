package com.woniuxy.inspector.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.inspector.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
