package com.woniuxy.inspector.entity;

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
 * @since 2023-09-13
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Parking对象", description = "")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("车位内部id")
      private Long id;

      @ApiModelProperty("路段id")
      private Long roadId;

      @ApiModelProperty("用户id")
      private Long userId;

      @ApiModelProperty("地磁id")
      private Integer magnetometerId;

      @ApiModelProperty("车位编号，类似A-112")
      private String number;

      @ApiModelProperty("车位名称")
      private String name;

      @ApiModelProperty("0有车，1无车，2未激活")
      private Integer status;

      @ApiModelProperty("备注")
      private String remarks;

      @ApiModelProperty("激活时间")
      private Date createTime;

    private Date updateTime;

      @ApiModelProperty("逻辑删除")
      private Integer logicDelete;


}
