package com.woniuxy.operator.enums;

import lombok.Getter;

/**
 * @Description: OrderStatusEnum
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnum {
    NO_PAY(1,"待支付"),
    ALREADY_PAY(2,"已支付"),
    RETURNING_MONEY(3,"退款中"),
    ALREADY_RETURN(4,"已退款"),
    OVERTIME_NO_PAY(5,"超时未支付"),
    IN_PROGRESS(6,"进行中"),
    ;



    private Integer code;

    private String describe;

    OrderStatusEnum(Integer code, String describe) {
        this.code = code;
        this.describe = describe;
    }
}
