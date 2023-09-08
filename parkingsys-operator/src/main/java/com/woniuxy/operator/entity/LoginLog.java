package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ToString
@TableName("login_log")
@ApiModel(value = "LoginLog对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Long userId;

    @ApiModelProperty("0-登录，1-退出")
    private Integer log;

    private String ip;

    @ApiModelProperty("日志创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer logicDelete;

    @ApiModelProperty("地址")
    private String location;

    @ApiModelProperty("浏览器")
    private String browser;


}
