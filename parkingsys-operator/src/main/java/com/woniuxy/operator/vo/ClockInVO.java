package com.woniuxy.operator.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClockInVO {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("巡检员名字")
    private String inspectorId;

    @ApiModelProperty("考勤状态0-未考勤，1-正常打卡")
    private Integer clockInStatus;

    @ApiModelProperty("执勤天数")
    private Long attendanceDay;

    @ApiModelProperty("请假天数")
    private Long leaveDays;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer logicDelete;

    @ApiModelProperty("正常天数")
    private Long NormalDays;

    private String inspectorName;

    private String roadName;
    private Long roadId;
    //出勤天数
    private Long attendanceDayCount;
    //正常上班
    private Long normalWorkingCount;
    //异常上班
    private Long abnormalWorkCount;
}
