package com.woniuxy.operator.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OperatorDTO;
import com.woniuxy.operator.entity.Operator;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.OperatorMapper;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IOperatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.OperatorVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-10
 */
@Service
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements IOperatorService {

    private final OperatorMapper operatorMapper;

    private final RoadMapper roadMapper;

    public OperatorServiceImpl(OperatorMapper operatorMapper, RoadMapper roadMapper){
        this.operatorMapper = operatorMapper;
        this.roadMapper = roadMapper;
    }

    @Override
    public PageInfo<OperatorVO> findPage(Integer pageNum, Integer pageSize, OperatorDTO operatorDTO) {

        PageHelper.startPage(pageNum,pageSize);
        List<OperatorVO> list =  operatorMapper.findPage(operatorDTO);
        return new PageInfo<>(list);
    }

    @Override
    public void saveRoad(List<String> nameList, String account) {

        Operator operator = operatorMapper.selectOne(Wrappers.lambdaQuery(Operator.class)
                .eq(Operator::getAccount, account));

        nameList.forEach(e -> {
            Road road = new Road();
            road.setName(e);
            road.setAdminId(operator.getId());
            roadMapper.insert(road);
        });
    }

    @Override
    public void updateOperator(OperatorVO operatorVO) {
        Operator operator = new Operator();
        operator.setUpdateTime(DateTime.now());
        operator.setOperatorName(operatorVO.getOperatorName());
        operator.setPhone(operatorVO.getPhone());
        operator.setArea(operatorVO.getArea());
        operator.setState(operatorVO.getState());

        operatorMapper.update(operator,
                Wrappers.<Operator>lambdaUpdate()
                        .eq(Operator::getOperatorName, operatorVO.getOperatorName()));
    }

    @Override
    public void updateState(OperatorVO operatorVO) {
        operatorMapper.update(new Operator(), Wrappers.lambdaUpdate(Operator.class)
                .eq(Operator::getOperatorName, operatorVO.getOperatorName())
                .set(Operator::getState, operatorVO.getState()));
    }

    @Override
    public void deleteOperator(OperatorVO operatorVO) {
        Operator operator = operatorMapper.selectOne(Wrappers.lambdaQuery(Operator.class)
                .eq(Operator::getOperatorName, operatorVO.getOperatorName()));

        operatorMapper.delete(Wrappers.lambdaUpdate(Operator.class)
                .eq(Operator::getOperatorName, operatorVO.getOperatorName()));

        roadMapper.delete(Wrappers.lambdaUpdate(Road.class)
                .eq(Road::getAdminId,operator.getId()));
    }
}
