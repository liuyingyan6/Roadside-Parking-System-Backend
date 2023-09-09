package com.woniuxy.operator.controller;

import com.woniuxy.operator.entity.Role;
import com.woniuxy.operator.pojos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Department;
import com.woniuxy.operator.service.IDepartmentService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-06
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final IDepartmentService departmentServiceImpl;

    public DepartmentController(IDepartmentService departmentServiceImpl){
        this.departmentServiceImpl = departmentServiceImpl;
    }

    // 查询全部
    @GetMapping("/all")
    public ResponseResult all(){
        List<Department> list = departmentServiceImpl.findAll();
        return ResponseResult.ok(list);
    }
}
