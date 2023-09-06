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
  @ApiModel(value = "Inspector对象", description = "")
public class Inspector implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

      @ApiModelProperty("巡检员名称")
      private String name;

      @ApiModelProperty("设备id")
      private Long pdaId;

      @ApiModelProperty("地址id")
      private Long chinaId;

      @ApiModelProperty("路段id")
      private Long roadId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer logicDelete;


}
