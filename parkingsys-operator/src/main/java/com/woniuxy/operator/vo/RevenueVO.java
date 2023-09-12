package com.woniuxy.operator.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class RevenueVO {
    private LocalDate date;
    private Integer orderCount;
    private BigDecimal revenue;
    private Integer refundOrderCount;
    private BigDecimal refundAmount;
    private Integer abnormalOrderCount;
    private BigDecimal abnormalAmount;
    private Integer userIncreaseCount;
}