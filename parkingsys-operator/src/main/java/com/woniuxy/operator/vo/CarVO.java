package com.woniuxy.operator.vo;

import lombok.Data;
import org.elasticsearch.search.DocValueFormat;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CarVO {
    private String carNumber;
    private String carTypeName;
    private String userName;
    private Integer orderCount;
    private Integer notPayCount;
    private BigDecimal orderAmount;
    private BigDecimal NotPayAmount;
    private Date createTime;
    private Date updateTime;

}
