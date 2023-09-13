package com.woniuxy.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.Gson;
import com.woniuxy.user.dto.UserDTO;
import com.woniuxy.user.entity.User;
import com.woniuxy.user.mapper.UserMapper;
import com.woniuxy.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.user.vo.CarVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean send(Map map, String phone) {
        if (StringUtils.isEmpty(phone)) return false;

        //下面导包看着点，千万别导错了，对着上面我的导包
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId("LTAI5tKs24BxzHSHy6Q6yuwY")
                // 您的AccessKey Secret	（这两个还不知道的去我前两次关于阿里云的有教程哪里找）
                .setAccessKeySecret("VsLCzyx7ddkaTF5iUK1SAuPOH9tGYc");
        // 访问的域名（这个不用变都是这个）
        config.endpoint = "dysmsapi.aliyuncs.com";
        Client client = null;
        try {
            client = new Client(config);
            SendSmsRequest request = new SendSmsRequest();

            request.setSignName("阿里云短信测试");//签名名称
            request.setTemplateCode("SMS_154950909");//模版Code
            request.setPhoneNumbers("17817053051");//电话号码
            //这里的参数是json格式的字符串
            request.setTemplateParam(JSONObject.toJSONString(map));
            SendSmsResponse response = client.sendSms(request);
            System.out.println("发送成功：" + new Gson().toJson(response));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CarVO> findAll(Long id) {

        return userMapper.list(id);
    }

    @Override
    public User login(UserDTO userDTO) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(StringUtils.hasLength(userDTO.getAccount()), User::getAccount, userDTO.getAccount());
        lqw.eq(StringUtils.hasLength(userDTO.getPassword()), User::getPassword, userDTO.getPassword());

        return userMapper.selectOne(lqw);
    }

}
