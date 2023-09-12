package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
  @TableName("magnetometer_log")
@ApiModel(value = "MagnetometerLog对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class MagnetometerLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer magnetometerId;

      @ApiModelProperty("地磁状态：0-在线，1-离线，2-未激活")
      private Integer magnetometerStatus;

      @ApiModelProperty("车位状态：0有车，1无车，2未激活")
      private Integer parkingStatus;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
