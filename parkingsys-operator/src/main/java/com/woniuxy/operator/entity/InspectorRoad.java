package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-06
 */
@Getter
@Setter
@ToString
@TableName("inspector_road")
@ApiModel(value = "InspectorRoad对象", description = "")
public class InspectorRoad implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("巡检员id")
    private Long inspectorId;

    @ApiModelProperty("路段id")
    private Long roadId;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
