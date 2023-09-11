package com.woniuxy.operator.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PdaVO {
    @ExcelProperty("编号")
    private Integer id;

    @ExcelProperty("pda名称")
    private String name;

    @ExcelProperty("路段名称")
    private String roadNames;

    @ExcelProperty("巡检员名字")
    private String inspectorName;

    @ExcelProperty("状态：1-在线，0-离线")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;
    private Integer inspectorId;
}
