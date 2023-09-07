package com.woniuxy.operator.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

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

    private String roadName;

    private Date dutyTime;
    private Date closingTime;

    private Date createTime;

}
