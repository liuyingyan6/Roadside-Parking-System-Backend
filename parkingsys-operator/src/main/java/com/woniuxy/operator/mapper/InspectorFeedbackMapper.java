package com.woniuxy.operator.mapper;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.vo.InspectorFeedbackDetailVO;
import com.woniuxy.operator.vo.InspectorFeedbackVO;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operator.entity.InspectorFeedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Mapper
public interface InspectorFeedbackMapper extends BaseMapper<InspectorFeedback> {

    List<InspectorFeedbackVO> findPage(@Param("inspectorDTO") InspectorDTO inspectorDTO);

    InspectorFeedbackDetailVO findDetail(Integer feedbackId);
}
