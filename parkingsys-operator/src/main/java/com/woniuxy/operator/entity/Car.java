package com.woniuxy.operator.entity;


import com.alibaba.excel.annotation.ExcelProperty;
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
  @ApiModel(value = "Car对象", description = "")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

      @ExcelProperty("编号")
      @ApiModelProperty("自增主键")
      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ExcelProperty("车牌号")
      @ApiModelProperty("车牌号码")
      private String carNumber;

      @ExcelProperty("车牌类型")
      @ApiModelProperty("车牌类型")
      private Integer carType;

      @ExcelProperty("用户id")
      @ApiModelProperty("用户id")
      private Long userId;

      @ExcelProperty("创建时间")
      @ApiModelProperty("创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ExcelProperty("更新时间")
      @ApiModelProperty("更新时间")
      @TableField(fill = FieldFill.UPDATE)
      private Date updateTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      @TableLogic
      private Integer logicDelete;


}
