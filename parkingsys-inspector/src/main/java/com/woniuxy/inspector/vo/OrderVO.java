package com.woniuxy.inspector.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Order对象", description = "")
public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long id;
    @ApiModelProperty("订单编号")
    private String orderNumber;

    @ApiModelProperty("车辆id")
    private Long carId;
    @ApiModelProperty("车牌号码")
    private String carNumber;

    @ApiModelProperty("泊车号id")
    private Long parkingId;
    @ApiModelProperty("泊位编号")
    private String parkingNumber;

    @ApiModelProperty("路段id")
    private Long roadId;
    @ApiModelProperty("路段名称")
    private String roadName;

    @ApiModelProperty("订单金额")
    private BigDecimal orderAmount;
    @ApiModelProperty("建枚举类，记录订单状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty("停车时长(时间差)")
    private String timeDiff;
}
