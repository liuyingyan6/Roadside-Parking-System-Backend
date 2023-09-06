package com.woniuxy.operator.dto;


import lombok.Data;

@Data
public class UserDTO {

    private String userName;  //昵称
    private String phone;     //手机号码
    private Integer vx;        //微信绑定
    private Integer state;     //状态
}
