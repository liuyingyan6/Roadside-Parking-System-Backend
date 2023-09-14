package com.woniuxy.operator.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "Charge对象", description = "")
@TableName("charge")
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收费内容id")
    private Long id;

    @ApiModelProperty("cid")
    private Long cid;

    @ApiModelProperty("收费规则的名称")
    private String chargingRule;

    @ApiModelProperty("时段类型:繁忙、非繁忙、收费、免费、禁停")
    private Integer timeType;

    @ApiModelProperty("时段")
    private String timePeriod;

    @ApiModelProperty("免费时长")
    private Integer freeDuration;

    @ApiModelProperty("收费标准")
    private BigDecimal chargeRate;

    @ApiModelProperty("封顶金额")
    private BigDecimal maximumCharge;


}
