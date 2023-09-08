package com.woniuxy.operator.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.operator.dto.RoadDTO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Road;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoadMapper extends BaseMapper<Road> {

    IPage<RoadDTO> selectRoadDTOPage(@Param("iPage")IPage iPage, @Param("name") String name,
                                     @Param("chargingRule") String chargingRule,
                                     @Param("inspectorName")String inspectorName);
}
