package com.woniuxy.operator.vo;

import lombok.Data;

@Data
public class OrderFunnelVO {
    private Integer totalOrderCount;
    private Integer finishedOrderCount;
    private Integer paidOrderCount;
    private Integer completedOrderCount;
}
