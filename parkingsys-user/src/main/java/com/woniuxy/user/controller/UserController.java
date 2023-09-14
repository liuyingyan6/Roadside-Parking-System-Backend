package com.woniuxy.user.controller;

import com.woniuxy.user.entity.User;
import com.woniuxy.user.pojos.ResponseResult;
import com.woniuxy.user.util.RandomUtil;
import com.woniuxy.user.vo.CarVO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.woniuxy.user.service.IUserService;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userServiceImpl;
    private final RedisTemplate redisTemplate;

    public UserController(IUserService userServiceImpl, RedisTemplate redisTemplate){
        this.userServiceImpl = userServiceImpl;
        this.redisTemplate = redisTemplate;
    }
//获取手机号码短信通知
    @GetMapping("/send/{phone}/interAspect")
    public void sendMsm(@PathVariable String phone){
        //从redis获取验证码，如果获取到直接返回
        String code= (String) redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)){
            return;
        }
        //如果redis获取不到，进行阿里云发送
        code=RandomUtil.getFourBitRandom();
        //生成随机数
       // String code = RandomUtil.getFourBitRandom();
        Map map = new HashMap();
        map.put("code",code);
        boolean b = userServiceImpl.send(map,phone);
        if (b){
            //如果发送成功，就把验证码存到redis里，设置5分钟有效时间
            redisTemplate.opsForValue().set(phone,code,30, TimeUnit.MINUTES);
            System.out.println("succees");
            System.out.println("验证码为"+code);
        }else {
            System.out.println("fail");
        }
    }

  //修改手机号码
    @PostMapping("/update")
    public ResponseResult  update(@RequestBody  User user){
        userServiceImpl.updateById(user);
        return ResponseResult.ok("修改成功");
    }

//显示绑定车牌号
    @PostMapping("/findAll/{id}")
    public ResponseResult findAll(@PathVariable  Long id){
        List<CarVO> all = userServiceImpl.findAll(id);
        return ResponseResult.ok(all);
    }
}
