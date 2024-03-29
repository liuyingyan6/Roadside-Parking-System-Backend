package com.woniuxy.operator.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
  @ApiModel(value = "Order对象", description = "")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("订单编号")
      private String id;

      @ApiModelProperty("车辆id")
      private Long carId;

      @ApiModelProperty("建枚举类，记录订单状态")
      private Integer status;

      @ApiModelProperty("订单金额")
      private BigDecimal orderAmount;

      @ApiModelProperty("0-支付宝，1-微信")
      private Integer payType;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
