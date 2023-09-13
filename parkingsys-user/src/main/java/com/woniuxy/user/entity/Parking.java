package com.woniuxy.user.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@Data
  @ApiModel(value = "Parking对象", description = "")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("车位内部id")
      private Long id;

      @ApiModelProperty("路段id")
      private Long roadId;

      @ApiModelProperty("地磁id")
      private Long magnetometerId;

      @ApiModelProperty("车位编号，类似A-112")
      private String number;

      @ApiModelProperty("车位名称")
      private String name;

      @ApiModelProperty("车位状态")
      private Long status;

      @ApiModelProperty("激活时间")
      private Date createTime;

      private Date updateTime;

      @ApiModelProperty("逻辑删除")
      private Integer logicDelete;


}
