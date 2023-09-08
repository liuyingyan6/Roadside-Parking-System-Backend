package com.woniuxy.operator.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.operator.dto.ClockInDTO;
import com.woniuxy.operator.dto.OrderDTO;
import com.woniuxy.operator.entity.ClockIn;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.ClockInVO;
import com.woniuxy.operator.vo.OrderVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IClockInService extends IService<ClockIn> {
    PageInfo<ClockInVO> findPage(Integer pageNum, Integer pageSize, ClockInDTO clockInDTO);
}
