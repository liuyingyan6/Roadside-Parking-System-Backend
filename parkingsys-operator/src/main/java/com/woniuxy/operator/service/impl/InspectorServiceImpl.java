package com.woniuxy.operator.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.common.enums.OrderStatusEnum;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.entity.Order;
import com.woniuxy.operator.mapper.InspectorMapper;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IInspectorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.InspectorVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    private final OrderMapper orderMapper;

    public InspectorServiceImpl(InspectorMapper inspectorMapper, RoadMapper roadMapper, OrderMapper orderMapper) {
        this.inspectorMapper = inspectorMapper;
        this.roadMapper = roadMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public PageInfo<InspectorVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO) {
        PageHelper.startPage(pageNum, pageSize);
        List<InspectorVO> page = inspectorMapper.findPage(inspectorDTO);
        page.stream().forEach(e -> {
            Integer code = OrderStatusEnum.ALREADY_PAY.getCode();
            Long ICount = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getId()), Order::getInspectorId, e.getId()));
            Long IFailedCount = orderMapper.selectCount(Wrappers.lambdaQuery(Order.class)
                    .eq(Objects.nonNull(e.getId()), Order::getInspectorId, e.getId())
                    .eq(Objects.nonNull(code), Order::getStatus, code));
            long l = IFailedCount / ICount;
            e.setOrderPercentage(l + "%");
        });

        return new PageInfo<>(page);
    }
}
