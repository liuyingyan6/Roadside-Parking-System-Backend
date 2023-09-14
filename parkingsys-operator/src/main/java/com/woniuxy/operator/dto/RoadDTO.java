package com.woniuxy.operator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadDTO {
    private Long id;
    private String roadName;
    private Integer state;

    private Long chargeId;
    private String chargingRule;

    private Long chinaId;
    private String chinaName;

    private Long inspectorId;
    private String inspectorName;

    private Long operatorId;
    private String operatorName;

    private Integer parkingCount;
    private Integer parkingLimit;

    private Date createTime;
}
