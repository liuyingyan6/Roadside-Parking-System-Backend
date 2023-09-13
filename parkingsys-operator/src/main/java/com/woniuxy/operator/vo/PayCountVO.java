package com.woniuxy.operator.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: PayCountVO
 * @Version 1.0
 */
@Data
public class PayCountVO {

    private Integer alipayCount;

    private Integer wechatCount;

    private Integer cashCount;

    private BigDecimal alipayAmount;

    private BigDecimal wechatAmount;

    private BigDecimal cashAmount;
}
