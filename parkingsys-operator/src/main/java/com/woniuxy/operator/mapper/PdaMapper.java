package com.woniuxy.operator.mapper;

import com.woniuxy.operator.vo.PdaVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.Pda;
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
public interface PdaMapper extends BaseMapper<Pda> {
    List<PdaVO> selectPageByKeyword(@Param("skipRow") Integer skipRow,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("pdaName") String pdaName,
                                    @Param("inspectorName") String inspectorName,
                                    @Param("roadName") String roadName);

    Long selectTotalCount(@Param("pdaName") String pdaName,
                          @Param("inspectorName") String inspectorName,
                          @Param("roadName") String roadName);
}
