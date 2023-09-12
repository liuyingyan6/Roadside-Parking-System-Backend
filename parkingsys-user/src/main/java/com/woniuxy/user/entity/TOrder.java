package com.woniuxy.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2023-09-12
 */
@Getter
@Setter
@ToString
  @TableName("t_order")
@ApiModel(value = "TOrder对象", description = "")
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("订单id")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("订单编号")
      private String orderNumber;

      @ApiModelProperty("巡检员id")
      private Long inspectorId;

      @ApiModelProperty("路段id")
      private Long roadId;

      @ApiModelProperty("车辆id")
      private Long carId;

      @ApiModelProperty("建枚举类，记录订单状态")
      private Integer status;

      @ApiModelProperty("订单金额")
      private BigDecimal orderAmount;

      @ApiModelProperty("0-支付宝，1-微信")
      private Integer payType;

      @ApiModelProperty("泊车号id")
      private Long parkingId;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
