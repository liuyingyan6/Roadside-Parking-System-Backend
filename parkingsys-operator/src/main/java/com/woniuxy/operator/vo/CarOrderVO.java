package com.woniuxy.operator.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CarOrderVO {
    private String carNumber;
    private String orderNumber;
    private Date createTime;
    private BigDecimal orderAmount;
    private Integer status;
    private Integer payType;
}
