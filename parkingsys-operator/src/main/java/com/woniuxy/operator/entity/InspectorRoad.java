package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
    private String  inspectorId;

    @ApiModelProperty("路段id")
    private Long roadId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)

    private Date updateTime;
    @TableLogic
    private Integer logicDelete;


}
