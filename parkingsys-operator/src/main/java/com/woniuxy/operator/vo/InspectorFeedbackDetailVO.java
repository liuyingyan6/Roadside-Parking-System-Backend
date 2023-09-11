package com.woniuxy.operator.vo;

import lombok.Data;

@Data
public class InspectorFeedbackDetailVO {

    private Integer feedbackId;

    private String inspectorName;

    private Integer magnetometerId;

    private String information;

    private Integer state;

    private String inspectorPhone;

    private String parkingName;

    private String imgUrls;

    private String resultInformation;
}
