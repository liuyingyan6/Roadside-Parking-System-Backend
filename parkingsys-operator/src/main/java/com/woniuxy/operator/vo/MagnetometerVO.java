package com.woniuxy.operator.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MagnetometerVO {
    private Integer magnetometerId;
    private String magnetometerName;
    private String roadName;
    private String parkingName;
    private String parkingStatus;
    private String magnetometerStatus;
    private Date createTime;
    private Date updateTime;
}
