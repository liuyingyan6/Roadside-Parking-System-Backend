package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.OperatorDTO;
import com.woniuxy.operator.entity.Operator;
import com.woniuxy.operator.vo.OperatorVO;

import java.util.List;

public interface IOperatorService extends IService<Operator> {

    PageInfo<OperatorVO> findPage(Integer pageNum, Integer pageSize, OperatorDTO operatorDTO);

    void saveRoad(List<String> nameList, String account);

    void updateOperator(OperatorVO operatorVO);

    void updateState(OperatorVO operatorVO);

    void deleteOperator(OperatorVO operatorVO);

    List<Operator> findByOperatorName(String operatorName);
}
