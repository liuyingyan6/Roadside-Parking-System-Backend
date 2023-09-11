package com.woniuxy.operator.vo;

import cn.hutool.db.DaoTemplate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
@Data
public class RoadOrderVO {
    private LocalDate orderDate;
    private Integer orderCount;//
    private Integer payCount;
    private BigDecimal payAmount;
    private Integer refundCount;
    private BigDecimal refundAmount;
    private Integer abnormalCount;
    private BigDecimal abnormalAmount;
    private Double paymenRate;
}
