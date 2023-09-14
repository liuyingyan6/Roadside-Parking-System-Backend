package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Inspector;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.InspectorVO;

import java.util.List;


public interface IInspectorService extends IService<Inspector> {

    PageInfo<InspectorVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO);

    void saveInspector(InspectorVO inspectorVO);

    void updateInspector(InspectorVO inspectorVO);

    void deleteById(String id);

    List<Inspector> findByInspectorName(String inspectorName);
}
