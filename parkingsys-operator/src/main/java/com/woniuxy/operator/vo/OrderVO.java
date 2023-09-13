package com.woniuxy.operator.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Order对象", description = "")
public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Excel(name = "订单id")
    @ApiModelProperty("订单id")
    private Long id;
    @Excel(name = "订单编号")
    @ApiModelProperty("订单编号")
    private String orderNumber;
   // @Excel(name = "巡检员id")
    @ApiModelProperty("巡检员id")
    private Long inspectorId;

   // @Excel(name = "路段id")
    @ApiModelProperty("路段id")
    private Long roadId;

   // @Excel(name = "车辆id")
    @ApiModelProperty("车辆id")
    private Long carId;
    @Excel(name = "记录订单状态")
    @ApiModelProperty("建枚举类，记录订单状态")
    private Integer status;
    @Excel(name = "订单金额")
    @ApiModelProperty("订单金额")
    private BigDecimal orderAmount;

   // @Excel(name = "支付类型")
    @ApiModelProperty("0-支付宝，1-微信")
    private Integer payType;
    //@Excel(name = "泊车号id")
    @ApiModelProperty("泊车号id")
    private Long parkingId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Excel(name = "提交时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //@Excel(name = "修改时间")
    private Date updateTime;
    //@Excel(name = "逻辑删除")
    private Integer logicDelete;
    @Excel(name = "泊车编号")
    private String parkingNumber;
    @Excel(name = "巡检员名称")
    @TableField("inspector_name")
    private String inspectorName;
    @Excel(name = "所属路段")
    private String roadName;
    @Excel(name = "车牌号")
    private String carNumber;

    private String orderCount;

}
