package com.woniuxy.operator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.InspectorMapper;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IInspectorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.InspectorVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class InspectorServiceImpl extends ServiceImpl<InspectorMapper, Inspector> implements IInspectorService {

    private final InspectorMapper inspectorMapper;
    private final RoadMapper roadMapper;

    public InspectorServiceImpl(InspectorMapper inspectorMapper, RoadMapper roadMapper) {
        this.inspectorMapper = inspectorMapper;
        this.roadMapper = roadMapper;
    }

    @Override
    public PageInfo<InspectorVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO) {
        PageHelper.startPage(pageNum, pageSize);
        List<InspectorVO> page = inspectorMapper.findPage(inspectorDTO);
        return new PageInfo<>(page);
    }

    /**
     * 远程搜索
     */
    @Override
    public List<Inspector> findByInspectorName(String inspectorName) {
        MPJLambdaWrapper<Inspector> wrapper = new MPJLambdaWrapper<Inspector>()
                .selectAll(Inspector.class)//查询InspectorRoad表全部字段
                .likeRight(StringUtils.hasLength(inspectorName), Inspector::getName, inspectorName);
        List<Inspector> inspectors = inspectorMapper.selectList(wrapper);
        return inspectors;
    }
}
