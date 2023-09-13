package com.woniuxy.operator.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ToString
@ApiModel(value = "Magnetometer对象", description = "")
@NoArgsConstructor
@AllArgsConstructor
public class Magnetometer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地磁编号")
    @ExcelProperty("地磁编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("地磁名称")
    @ExcelProperty("地磁名称")
    private String name;

    @ApiModelProperty("绑定泊位id")
    @ExcelProperty("绑定泊位id")
    private Long parkingId;

    @ApiModelProperty("地磁状态：0-在线，1-离线，2-未激活")
    @ExcelProperty("地磁状态：0-在线，1-离线，2-未激活")
    private Integer status;

    @ExcelProperty("创建时间")
    @ColumnWidth(10)
    private Date createTime;

    @ExcelProperty("更新时间")
    @ColumnWidth(10)
    private Date updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer logicDelete;


}
