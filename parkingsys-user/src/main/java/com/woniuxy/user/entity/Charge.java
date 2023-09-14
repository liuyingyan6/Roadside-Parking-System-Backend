package com.woniuxy.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
  @ApiModel(value = "Charge对象", description = "")
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

    private String chargingRule;

    private byte[] cid;

      @ApiModelProperty("1繁忙、2非繁忙、3收费、4免费、5禁停")
      private Integer timeType;

      @ApiModelProperty("时段")
      private String timePeriod;

      @ApiModelProperty("免费时长")
      private Integer freeDuration;

      @ApiModelProperty("收费标准")
      private BigDecimal chargeRate;

      @ApiModelProperty("封顶金额")
      private BigDecimal maximumCharge;


}
