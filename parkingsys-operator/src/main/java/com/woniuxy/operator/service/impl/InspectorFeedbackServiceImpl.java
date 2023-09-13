package com.woniuxy.operator.service.impl;

import cn.hutool.core.net.URLDecoder;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InformationDTO;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.InspectorFeedback;
import com.woniuxy.operator.mapper.InspectorFeedbackMapper;
import com.woniuxy.operator.service.IInspectorFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.InspectorFeedbackDetailVO;
import com.woniuxy.operator.vo.InspectorFeedbackVO;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Service
public class InspectorFeedbackServiceImpl extends ServiceImpl<InspectorFeedbackMapper, InspectorFeedback> implements IInspectorFeedbackService {

    private final InspectorFeedbackMapper inspectorFeedbackMapper;

    public InspectorFeedbackServiceImpl(InspectorFeedbackMapper inspectorFeedbackMapper){
        this.inspectorFeedbackMapper = inspectorFeedbackMapper;
    }

    @Override
    public InspectorFeedbackDetailVO findDetail(Integer feedbackId) {
        InspectorFeedbackDetailVO detailVO = inspectorFeedbackMapper.findDetail(feedbackId);
        return detailVO;
    }

    @Override
    public PageInfo<InspectorFeedbackVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO) {
        PageHelper.startPage(pageNum,pageSize);
        List<InspectorFeedbackVO> list = inspectorFeedbackMapper.findPage(inspectorDTO);
        return new PageInfo<>(list);
    }

    @Override
    public void saveFeedback(Integer fId, String information) {

        InspectorFeedback inspectorFeedback = inspectorFeedbackMapper.selectOne(Wrappers.lambdaQuery(InspectorFeedback.class)
                .eq(InspectorFeedback::getFeedbackId, fId));

        // 如果查询结果不为空，则将反馈信息添加到记录中
        if (inspectorFeedback != null) {
            inspectorFeedback.setResultInformation(information);
            inspectorFeedback.setState(0);
            this.updateById(inspectorFeedback);
        }
    }

}
