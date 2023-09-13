package com.woniuxy.operator.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class InspectorFeedbackVO {

    private Long id;

    private Integer feedbackId;

    private String name;

    private String phone;

    private Integer magnetometerId;

    private String number;

    private Date createTime;

    private Integer state;

    private Date updateTime;
}
