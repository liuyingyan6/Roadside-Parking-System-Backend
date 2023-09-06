package com.woniuxy.operator.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
  @ApiModel(value = "Magnetometer对象", description = "")
public class Magnetometer implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("地磁编号")
        private Integer id;

      @ApiModelProperty("地磁名称")
      private String name;

      @ApiModelProperty("绑定泊位id")
      private Long parkingId;

      @ApiModelProperty("地磁状态：0-在线，1-离线，2-未激活")
      private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer logicDelete;


}
