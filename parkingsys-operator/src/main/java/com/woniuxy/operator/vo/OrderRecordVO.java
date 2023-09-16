package com.woniuxy.operator.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRecordVO {

    private Long id;
    private String orderNumber;
    private Date updateTime;
    private String carNumber;
    private BigDecimal orderAmount;
    private Integer status;
    private Integer payType;

}
