package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.Role;
import com.woniuxy.operator.service.IRoleService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleServiceImpl;

    public RoleController(IRoleService roleServiceImpl){
        this.roleServiceImpl = roleServiceImpl;
    }

    // 提交修改
    @PostMapping("/update")
    public ResponseResult updateRole(@RequestBody Role role){
        roleServiceImpl.updateById(role);
        return ResponseResult.ok();
    }

    // 删除数据
    @DeleteMapping("/delete/{id}")
    public ResponseResult deleteRole(@PathVariable("id") Long id){
        roleServiceImpl.deleteRole(id);
        return ResponseResult.ok();
    }

    // 提交新增
    @PostMapping("/add")
    public ResponseResult addRole(@RequestBody Role role){
        roleServiceImpl.save(role);
        return ResponseResult.ok();
    }

    // 查询全部
    @GetMapping("/all")
    public ResponseResult all(){
        List<Role> list = roleServiceImpl.findAll();
        return ResponseResult.ok(list);
    }

    // 分页加载表单数据&查询
    @GetMapping("/findAll2Page")
    public ResponseResult findAll2Page(Integer pageNum, Integer pageSize, String name){
        Page<Role> page = Page.of(pageNum,pageSize);
        PageVO<Role> vo =  roleServiceImpl.findAll2Page(page,name);
        return ResponseResult.ok(vo);
    }
}
