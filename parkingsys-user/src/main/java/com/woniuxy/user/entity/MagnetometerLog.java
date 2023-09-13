package com.woniuxy.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2023-09-12
 */
@Getter
@Setter
@ToString
  @TableName("magnetometer_log")
@ApiModel(value = "MagnetometerLog对象", description = "")
public class MagnetometerLog implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private Integer magnetometerId;

      @ApiModelProperty("地磁状态：0-在线，1-离线，2-未激活")
      private Integer magnetometerStatus;

      @ApiModelProperty("车位状态：0有车，1无车，2未激活")
      private Integer parkingStatus;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    private Integer logicDelete;


}
