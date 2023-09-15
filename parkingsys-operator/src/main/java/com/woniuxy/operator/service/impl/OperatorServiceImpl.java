package com.woniuxy.operator.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.woniuxy.operator.dto.OperatorDTO;
import com.woniuxy.operator.entity.Inspector;
import com.woniuxy.operator.entity.Operator;
import com.woniuxy.operator.entity.Road;
import com.woniuxy.operator.mapper.OperatorMapper;
import com.woniuxy.operator.mapper.RoadMapper;
import com.woniuxy.operator.service.IOperatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.operator.vo.OperatorVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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
            road.setRoadName(e);
            road.setOperatorId(operator.getId());
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
        Operator operator1 = operatorMapper.selectOne(Wrappers.lambdaQuery(Operator.class)
                .eq(Operator::getOperatorName, operatorVO.getOperatorName()));
        roadMapper.delete(Wrappers.lambdaQuery(Road.class)
                .eq(Road::getOperatorId,operator1.getId()));
        List<String> nameList = operatorVO.getNameList();
        saveRoad(nameList,operator1.getAccount());
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
                .eq(Road::getOperatorId,operator.getId()));
    }

    @Override
    public List<Operator> findByOperatorName(String operatorName) {
        MPJLambdaWrapper<Operator> wrapper = new MPJLambdaWrapper<Operator>()
                .selectAll(Operator.class)//查询InspectorRoad表全部字段
                .likeRight(StringUtils.hasLength(operatorName), Operator::getOperatorName, operatorName);
        List<Operator> operators = operatorMapper.selectList(wrapper);
        return operators;
    }

}
