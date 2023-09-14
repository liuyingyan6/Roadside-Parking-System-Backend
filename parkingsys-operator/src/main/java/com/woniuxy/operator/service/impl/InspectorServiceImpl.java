package com.woniuxy.operator.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.common.enums.OrderStatusEnum;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.*;
import com.woniuxy.operator.mapper.ChargeMapper;
import com.woniuxy.operator.mapper.InspectorMapper;
import com.woniuxy.operator.mapper.InspectorRoadMapper;
import com.woniuxy.operator.mapper.OrderMapper;
import com.woniuxy.operator.service.IInspectorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.service.IOrderService;
import com.woniuxy.operator.vo.InspectorRoadVO;
import com.woniuxy.operator.vo.InspectorVO;
import com.woniuxy.operator.vo.OrderConversionVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private final InspectorRoadMapper inspectorRoadMapper;
    private final IOrderService orderServiceImpl;
    private final ChargeMapper chargeMapper;

    public InspectorServiceImpl(InspectorMapper inspectorMapper, InspectorRoadMapper inspectorRoadMapper, IOrderService orderServiceImpl, ChargeMapper chargeMapper) {
        this.inspectorMapper = inspectorMapper;
        this.inspectorRoadMapper = inspectorRoadMapper;
        this.orderServiceImpl = orderServiceImpl;
        this.chargeMapper = chargeMapper;
    }

    @Override
    public PageInfo<InspectorVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO) {
        PageHelper.startPage(pageNum, pageSize);

        List<InspectorVO> page = inspectorMapper.findPage(inspectorDTO);

        page.stream().forEach(e -> {
            Integer code = OrderStatusEnum.ALREADY_PAY.getCode();

            OrderConversionVO orderConversionVO = orderServiceImpl.orderStatusCount(e.getId());

            BigDecimal divide = BigDecimal.valueOf(orderConversionVO.getPaidOrderCount() * 100)
                    .divide(BigDecimal.valueOf(orderConversionVO.getTotalOrderCount()), 2, RoundingMode.HALF_UP);
            e.setOrderPercentage(divide + "%");

//            Charge charge = chargeMapper.selectById(e.getChargeId());
            e.setTimePeriod("9:00-17:00");

            MPJLambdaWrapper<InspectorRoad> wrapper = new MPJLambdaWrapper<InspectorRoad>()
                    .selectAll(InspectorRoad.class)//查询InspectorRoad表全部字段
                    .selectAs(Road::getRoadName, InspectorRoadVO::getRoadName)
                    .leftJoin(Road.class, Road::getId, InspectorRoad::getRoadId)
                    .eq(Objects.nonNull(e.getId()), InspectorRoad::getInspectorId, e.getId());
            List<InspectorRoadVO> inspectorRoadVOS = inspectorRoadMapper.selectJoinList(InspectorRoadVO.class, wrapper);
            e.setInspectorRoadVO(inspectorRoadVOS);
        });
        return new PageInfo<>(page);
    }

    @Override
    public void saveInspector(InspectorVO inspectorVO) {
        Inspector inspector = new Inspector();
        BeanUtil.copyProperties(inspectorVO, inspector);
        inspectorMapper.insert(inspector);
        inspectorVO.getInspectorRoadVO().stream().forEach(e -> {
            InspectorRoad inspectorRoad = new InspectorRoad();
            inspectorRoad.setRoadId(e.getId());
            inspectorRoad.setInspectorId(inspector.getId());
            inspectorRoadMapper.insert(inspectorRoad);
        });
    }

    @Override
    public void updateInspector(InspectorVO inspectorVO) {
        Inspector inspector = new Inspector();
        BeanUtil.copyProperties(inspectorVO, inspector);
        inspectorMapper.updateById(inspector);
        inspectorRoadMapper.delete(Wrappers.lambdaQuery(InspectorRoad.class)
                .eq(Objects.nonNull(inspector.getId()), InspectorRoad::getInspectorId, inspector.getId()));

        inspectorVO.getInspectorRoadVO().stream().forEach(e -> {
            InspectorRoad inspectorRoad = new InspectorRoad();
            if (e.getRoadId() == null) {
                e.setRoadId(e.getId());
            }
            inspectorRoad.setRoadId(e.getRoadId());
            inspectorRoad.setInspectorId(inspector.getId());
            inspectorRoadMapper.insert(inspectorRoad);
        });
    }

    @Override
    public void deleteById(String id) {
        inspectorMapper.deleteById(id);
        inspectorRoadMapper.delete(Wrappers.lambdaQuery(InspectorRoad.class)
                .eq(StringUtils.hasLength(id), InspectorRoad::getInspectorId, id));
    }
}
