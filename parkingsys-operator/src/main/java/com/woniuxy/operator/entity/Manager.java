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
  @ApiModel(value = "Manager对象", description = "")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("部门id")
      private Long departmentId;

      @ApiModelProperty("登录账号")
      private String account;

      @ApiModelProperty("密码")
      private String password;

      @ApiModelProperty("手机号")
      private String telephone;

      @ApiModelProperty("管理员姓名")
      private String name;

      @ApiModelProperty("账户是否锁定（0-锁定，1-未锁定）")
      private Integer locked;

      @ApiModelProperty("账户是否锁定（0-正常，1-停用）")
      private Integer status;

      @ApiModelProperty("创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty("修改时间")
      @TableField(fill = FieldFill.UPDATE)
      private Date updateTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      @TableLogic
      private Integer logicDelete;


}
