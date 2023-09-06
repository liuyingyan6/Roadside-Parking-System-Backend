package com.woniuxy.operator.entity;

import lombok.Data;
import org.elasticsearch.search.DocValueFormat;


import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class CarVO {
    private String carNumber;
    private String carTypeName;
    private String userName;
    private Integer orderCount;
    private Integer notPayCount;
    private BigDecimal orderAmount;
    private BigDecimal NotPayAmount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
