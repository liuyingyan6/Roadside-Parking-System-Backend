package com.woniuxy.operator.entity;

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
  @ApiModel(value = "Pda对象", description = "")
public class Pda implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("pda编号")
        private Long id;

      @ApiModelProperty("设备名称")
      private String name;

      @ApiModelProperty("所属路段id")
      private Long roadId;

      @ApiModelProperty("设备状态：1-在线，0-离线")
      private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
