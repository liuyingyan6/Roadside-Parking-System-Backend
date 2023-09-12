package com.woniuxy.operator.vo;

import lombok.Data;

@Data
public class ClockInVO {
    //出勤天数
    private Long attendanceDayCount;
    //正常上班
    private Long normalWorkingCount;
    //异常上班
    private Long abnormalWorkCount;
}
