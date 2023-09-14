package com.woniuxy.operator.mapper;
import com.woniuxy.operator.vo.CarVO;
import com.woniuxy.operator.vo.CarOrderVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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

    List<CarOrderVO> getCarOrderList(String carNumber);

    void liftCar(Integer carId);

    void liftUser(Integer userId);


    Car getCarInfo(String carNumber);

    List<String> getTime(@Param("startDate") String startDate,@Param("endDate") String endDate);
}
