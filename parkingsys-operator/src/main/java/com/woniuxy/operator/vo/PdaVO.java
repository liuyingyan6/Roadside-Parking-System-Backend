package com.woniuxy.operator.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PdaVO {
    private Integer pdaId;
    private String pdaName;
    private String roadName;
    private String inspectorName;
    private Integer pdaStatus;
    private Date creatTime;
}
