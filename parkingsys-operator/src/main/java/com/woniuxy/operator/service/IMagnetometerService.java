package com.woniuxy.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.entity.Magnetometer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.operator.vo.MagnetometerVO;
import com.woniuxy.operator.vo.PageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IMagnetometerService extends IService<Magnetometer> {

    List<MagnetometerVO> getByKeyword(String magnetometerName, String roadName);
}
