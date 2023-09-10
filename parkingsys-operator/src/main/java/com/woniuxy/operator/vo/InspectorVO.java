package com.woniuxy.operator.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description: AuthorizationDTO
 * @Date 2023/8/31 20:00
 * @Version 1.0
 */
@Data
public class InspectorVO {

    private Long id;

    private String name;
    private String phone;

    private Integer state;
    private String password;
    private List<InspectorRoadVO> inspectorRoadVO;
    private String timePeriod;
    private String orderPercentage;
    private Date createTime;

}
