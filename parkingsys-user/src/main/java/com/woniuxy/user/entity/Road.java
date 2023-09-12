package com.woniuxy.user.entity;

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
  @ApiModel(value = "Road对象", description = "")
public class Road implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("路段id")
      private Long id;

      @ApiModelProperty("地址id")
      private Long chinaId;

      @ApiModelProperty("巡检员id")
      private Long inspectorId;

      @ApiModelProperty("运维员id")
      private Long adminId;

      @ApiModelProperty("收费标准id(收费类型)")
      private Long chargeId;

      @ApiModelProperty("路段名称")
      private String roadName;

      @ApiModelProperty("路段状态，0正常，1禁用")
      private Integer state;

      @ApiModelProperty("路段车位数")
      private Long parkingCount;

      @ApiModelProperty("限制车位数")
      private Integer parkingLimit;

    private Date createTime;

    private Date updateTime;

      @ApiModelProperty("逻辑删除")
      private Integer logicDelete;


}
