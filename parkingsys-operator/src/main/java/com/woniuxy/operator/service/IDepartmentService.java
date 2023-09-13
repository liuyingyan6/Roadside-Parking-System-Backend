package com.woniuxy.operator.service;

import com.woniuxy.operator.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-06
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> findAll();
}
