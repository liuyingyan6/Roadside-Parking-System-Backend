package com.woniuxy.operator.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.mapper.InspectorMapper;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IInspectorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.InspectorVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
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
}
