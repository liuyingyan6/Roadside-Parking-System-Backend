package com.woniuxy.operator.vo;

import com.woniuxy.operator.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: CountOrderVO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountOrderVO {

    private BigDecimal TotalAmount;

    private BigDecimal RefundAmount;

    private List<Order> OrderList;
}
