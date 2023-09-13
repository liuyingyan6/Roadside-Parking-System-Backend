package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InformationDTO;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.InspectorFeedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.InspectorFeedbackDetailVO;
import com.woniuxy.operator.vo.InspectorFeedbackVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IInspectorFeedbackService extends IService<InspectorFeedback> {

    PageInfo<InspectorFeedbackVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO);

    void saveFeedback(Integer fId, String information);

    InspectorFeedbackDetailVO findDetail(Integer feedbackId);
}
