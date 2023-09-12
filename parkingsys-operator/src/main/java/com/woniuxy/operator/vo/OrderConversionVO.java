package com.woniuxy.operator.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderConversionVO {
    //所有订单数量
    private Long totalOrderCount;
    //已完成
    private Long finishedParkingOrderCount;
    //需要支付的
    private Long validOrderCount;
    //已支付
    private Long paidOrderCount;
    //异常订单
    private Long unusualOrderCount;
}
