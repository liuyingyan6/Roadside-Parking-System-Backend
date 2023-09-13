package com.woniuxy.operator.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: PayCountVO
 * @Version 1.0
 */
@Data
public class PayDateVO {

    private String orderDate;

    private Integer alipayCountDate;

    private Integer wechatCountDate;

    private Integer cashCountDate;

    private BigDecimal alipayAmountDate;

    private BigDecimal wechatAmountDate;

    private BigDecimal cashAmountDate;
}
