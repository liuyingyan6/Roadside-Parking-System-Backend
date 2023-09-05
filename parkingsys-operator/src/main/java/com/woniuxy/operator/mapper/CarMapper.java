package com.woniuxy.operator.mapper;
import com.woniuxy.operator.entity.CarVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    List<CarVO> getCar(String carNumber);

    Integer getCarOrderCount(String carNumber);

     BigDecimal getNotPayAmount(String carNumber);

     Integer getNotPayCount(String carNumber);

     BigDecimal getPayAmount(String carNumber);
}
