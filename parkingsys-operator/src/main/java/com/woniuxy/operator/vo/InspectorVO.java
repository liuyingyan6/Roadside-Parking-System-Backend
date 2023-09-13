package com.woniuxy.operator.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class InspectorVO {

    private Long id;

    private String name;
    private String phone;

    private Integer state;
    private Long chargeId;

    private String password;
    private String timePeriod;
    private List<InspectorRoadVO> inspectorRoadVO;
    private String orderPercentage;
    private Date createTime;

}
