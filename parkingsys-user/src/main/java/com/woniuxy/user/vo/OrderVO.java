package com.woniuxy.user.vo;



import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Data
public class OrderVO {

    private Long id;
    private String orderNumber;

    private String roadName;

    private String carNumber;
    private String parkingNumber;

    private Integer status;
    private BigDecimal orderAmount;

    private Date createTime;


}
