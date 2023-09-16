package com.woniuxy.operator.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operator.dto.CarConditionDTO;
import com.woniuxy.operator.dto.OrderRecordDTO;
import com.woniuxy.operator.dto.UserDTO;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.vo.*;
import org.springframework.web.bind.annotation.*;
import com.woniuxy.operator.entity.User;
import com.woniuxy.operator.service.IUserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final IUserService userServiceImpl;

    public UserController(IUserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    //用户——订单记录
    @PostMapping("/orderRecordPage/{pageNum}/{pageSize}/{userId}")
    public ResponseResult orderRecordPage(@PathVariable("pageNum") Integer pageNum,
                                           @PathVariable("pageSize")Integer pageSize,
                                           @PathVariable("userId")Long userId,
                                           @RequestBody OrderRecordDTO orderRecordDTO){

        PageVO<OrderRecordVO> VO = userServiceImpl.orderRecordPage(pageNum, pageSize, userId, orderRecordDTO);
        return ResponseResult.ok(VO);

    }




    //用户——车辆情况
    @PostMapping("/carConditionPage/{pageNum}/{pageSize}/{userId}")
    public ResponseResult carConditionPage(@PathVariable("pageNum") Integer pageNum,
                                       @PathVariable("pageSize")Integer pageSize,
                                       @PathVariable("userId")Long userId,
                                       @RequestBody CarConditionDTO carConditionDTO){

        PageVO<CarConditionVO> VO = userServiceImpl.carConditionPage(pageNum, pageSize, userId, carConditionDTO);
        return ResponseResult.ok(VO);

    }

    //用户——账户信息
    @GetMapping("/accountPage/{id}")
    public ResponseResult accountPage(@PathVariable("id") Long id){
        AccountVO accountVO = userServiceImpl.accountPage(id);
        return ResponseResult.ok(accountVO);
    }

    //用户——分页
    @PostMapping("/findPage/{pageNum}/{pageSize}")
    public ResponseResult findPage(@PathVariable("pageNum") Integer pageNum,
                                   @PathVariable("pageSize") Integer pageSize,
                                   @RequestBody UserDTO userDTO) {
        Page<User> page = Page.of(pageNum-1,pageSize);
        PageVO<UserVO> vo = userServiceImpl.findPage(page,userDTO);
        return ResponseResult.ok(vo);
    }

    //用户——禁用
    @PutMapping("/update")
    public ResponseResult update(@RequestBody User user){
        Integer num;
        if (user.getState()!=1){
            user.setState(1);
            num=1;
        }else {
            user.setState(0);
            num=0;
        }
        userServiceImpl.updateById(user);
        return ResponseResult.ok(user.getState());
    }
}
