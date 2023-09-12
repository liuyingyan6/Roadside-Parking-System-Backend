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


    private Integer id;

    private String inspectorId;

    private Date createTime;

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
