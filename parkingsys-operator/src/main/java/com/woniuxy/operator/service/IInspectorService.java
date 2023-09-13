package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.InspectorDTO;
import com.woniuxy.operator.entity.Inspector;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.InspectorVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IInspectorService extends IService<Inspector> {

    PageInfo<InspectorVO> findPage(Integer pageNum, Integer pageSize, InspectorDTO inspectorDTO);

    void saveInspector(InspectorVO inspectorVO);

    void updateInspector(InspectorVO inspectorVO);

    void deleteById(String id);
}
