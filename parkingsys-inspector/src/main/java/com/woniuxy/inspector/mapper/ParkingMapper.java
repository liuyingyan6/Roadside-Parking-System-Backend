package com.woniuxy.inspector.mapper;
import com.woniuxy.inspector.vo.ParkingVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.inspector.entity.Parking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-13
 */
@Mapper
public interface ParkingMapper extends BaseMapper<Parking> {
List<ParkingVO>find();
}
