package com.woniuxy.operator.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserFeedbackVO {


    private Long id;

    private String userName;

    private String result;
    private String feedbackOdd;
    private String feedbackText;

    private String phone;

    private Integer state;

    private String imgSrc;
    private String imgCount;
    private Date createTime;

    private Date updateTime;

}
