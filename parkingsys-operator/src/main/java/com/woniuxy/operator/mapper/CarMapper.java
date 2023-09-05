package com.woniuxy.operator.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {

}
