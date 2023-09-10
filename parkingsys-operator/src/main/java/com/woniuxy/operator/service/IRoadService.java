package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.Road;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
public interface IRoadService extends IService<Road> {

    List<Road> findAllByRoadName(String roadName);
}
