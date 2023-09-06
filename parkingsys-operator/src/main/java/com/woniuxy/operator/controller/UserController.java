package com.woniuxy.operator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.PageVO;
import com.woniuxy.operator.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.service.IUserService;
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
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final IUserService userServiceImpl;

    public UserController(IUserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }



    //用户——分页
    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,  @RequestBody UserDTO userDTO) {
        Page<User> page = Page.of(pageNum-1,pageSize);
        PageVO<UserVO> vo = userServiceImpl.findPage(page,userDTO);
        return ResponseResult.ok(vo);
    }

    //用户——修改
    @PostMapping("/update")
    private ResponseResult update(@RequestBody User user){
        userServiceImpl.updateById(user);
        return ResponseResult.ok();
    }



    //用户——删除
    @GetMapping ("/delete")
    private ResponseResult delete(User user){
        userServiceImpl.removeById(user);
        return ResponseResult.ok();
    }


    //用户——添加
    @PostMapping("add")
    private ResponseResult add(@RequestBody User user){
        userServiceImpl.save(user);
        return ResponseResult.ok();
    }
}
