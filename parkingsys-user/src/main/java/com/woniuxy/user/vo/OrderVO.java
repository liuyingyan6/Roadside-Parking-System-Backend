package com.woniuxy.user.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("订单编号")
    private String orderNumber;


    @ApiModelProperty("订单金额")
    private BigDecimal orderAmount;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")

    private Date createTime;

    private String parkingNumber;

    @TableField("inspector_name")
    private String inspectorName;

    private String roadName;

    private String carNumber;



}
