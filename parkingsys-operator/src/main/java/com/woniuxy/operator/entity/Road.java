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

/**
 * <p>
 *
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Getter
@Setter
@ToString
@ApiModel(value = "Road对象", description = "")
public class Road implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("路段id")
    private Long id;

    @ApiModelProperty("地址id")
    private Long chinaId;

    @ApiModelProperty("巡检员id")
    private Long inspectorId;

    @ApiModelProperty("运维员id")
    private Long adminId;

    @ApiModelProperty("收费标准id(收费类型)")
    private Long chargeId;

    @ApiModelProperty("路段名称")
    private String roadName;

    @ApiModelProperty("限制车位数")
    private Integer parkingLimit;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer logicDelete;


}
