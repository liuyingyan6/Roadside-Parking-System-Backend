package com.woniuxy.operator.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

@Data
public class MagnetometerVO {
    @ExcelProperty("地磁编号")
    private Integer id;

    @ExcelProperty("地磁名称")
    private String name;

    @ExcelProperty("路段名称")
    @ColumnWidth(10)
    private String roadName;

    @ExcelProperty("泊位名称")
    @ColumnWidth(10)
    private String parkingName;

    @ExcelProperty("泊位状态：0-有车，2-无车，2-未激活")
    private Integer parkingStatus;

    @ExcelProperty("地磁状态：0-在线，1-离线，2-未激活")
    private Integer status;

    @ExcelProperty("创建时间")
    private Date createTime;

    @ExcelProperty("最近更新时间")
    private Date updateTime;
    private Long parkingId;
}
