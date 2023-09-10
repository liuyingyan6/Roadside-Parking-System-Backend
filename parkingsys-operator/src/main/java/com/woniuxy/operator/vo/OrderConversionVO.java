package com.woniuxy.operator.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderConversionVO {
    private Integer totalOrderCount;
    private Integer finishedParkingOrderCount;
    private Integer validOrderCount;
    private Integer paidOrderCount;
}
