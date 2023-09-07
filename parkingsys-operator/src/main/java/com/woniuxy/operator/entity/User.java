package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("用户id")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("用户账号")
      private String account;

      @ApiModelProperty("用户密码")
      private String password;

      @ApiModelProperty("用户姓名")
      private String userName;

      @ApiModelProperty("手机号码")
      private String phone;

      @ApiModelProperty("用户状态（0-正常，1-销户）")
      private Integer state;

      @ApiModelProperty("用户邮箱")
      private String email;

      @ApiModelProperty("车辆id")
      private Long carId;

      @ApiModelProperty("微信绑定 0 1")
      private Integer vx;

      @ApiModelProperty("创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty("修改时间")
      @TableField(fill = FieldFill.UPDATE)
      private Date updateTime;

      @ApiModelProperty("禁用")
      @TableLogic
      private Integer logicDelete;



}
