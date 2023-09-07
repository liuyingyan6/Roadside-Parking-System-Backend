package com.woniuxy.operator.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "Parking对象", description = "")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车位内部id")
    private Long id;

    @ApiModelProperty("路段id")
    private Long roadId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("地磁id")
    private Integer geomagneticId;

    @ApiModelProperty("车位编号，类似A-112")
    private String number;

    @ApiModelProperty("车位名称")
    private String name;

    @ApiModelProperty("0有车，1无车，2未激活")
    private Integer status;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("激活时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer logicDelete;


}
