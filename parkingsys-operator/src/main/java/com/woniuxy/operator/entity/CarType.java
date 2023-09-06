package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

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
@TableName("car_type")
@ApiModel(value = "CarType对象", description = "")
public class CarType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String carTypeName;


}
