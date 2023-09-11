package com.woniuxy.operator.service.impl;

import com.woniuxy.operator.entity.Department;
import com.woniuxy.operator.mapper.DepartmentMapper;
import com.woniuxy.operator.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-06
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = departmentMapper.selectList(null);
        return departments;
    }
}
