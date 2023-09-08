package com.woniuxy.operator.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.operator.dto.ParkingDTO;
import com.woniuxy.operator.dto.RoadDTO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Parking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ParkingMapper extends BaseMapper<Parking> {
    IPage<ParkingDTO> selectParkDTOPage(@Param("iPage")IPage iPage,
                                        @Param("name") String name);
}
