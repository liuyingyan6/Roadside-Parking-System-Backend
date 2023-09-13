package com.woniuxy.operator.vo;

import lombok.Data;

import java.util.Date;


@Data
public class RoadVO {

    private Long id;
    private String name;

    private Long chargeId;
    private Long inspectorId;
    private Long operatorId;
}
