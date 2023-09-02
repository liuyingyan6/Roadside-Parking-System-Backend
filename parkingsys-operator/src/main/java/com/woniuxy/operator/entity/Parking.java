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
 * @since 2023-09-02
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Parking对象", description = "")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

      @ApiModelProperty("地址")
      private Integer chinaId;

      @ApiModelProperty("停车场名字")
      private String name;

      @ApiModelProperty("建枚举类，0-全天收费")
      private Integer chargingType;

      @ApiModelProperty("车位数")
      private Integer parkingCount;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
