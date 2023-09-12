package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.ClockInDTO;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.ClockIn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.ClockInVO;

import java.util.List;
import com.woniuxy.operator.vo.ClockInVO;
import com.woniuxy.operator.vo.OrderVO;
import com.woniuxy.operator.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IClockInService extends IService<ClockIn> {
    List<ClockIn> findByInspetorId(String inspectorId, String month);

    ClockInVO findByInspectorIdCount(String inspectorId, String month);
    PageVO<ClockInVO> findPage(Integer pageNum, Integer pageSize, ClockInDTO clockInDTO);
}
