package com.woniuxy.operator.vo;


import lombok.Data;

import java.util.Date;

@Data
public class UserVO {

    private Long id;
    private String userName;
    private String phone;
    private Long carNum;
    private Long orderNum;
    private Long notOrderNum;
    private Integer vx;
    private Integer state;
    private Date createTime;
}
