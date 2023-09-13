package com.woniuxy.operator.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@ApiModel(value = "Order对象", description = "")
@TableName(value = "t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
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

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer logicDelete;


}
