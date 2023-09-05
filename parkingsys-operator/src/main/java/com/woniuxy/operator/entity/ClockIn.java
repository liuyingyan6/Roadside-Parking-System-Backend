package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
  @TableName("clock_in")
@ApiModel(value = "ClockIn对象", description = "")
public class ClockIn implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("巡检员名字")
      private String inspectorId;

      @ApiModelProperty("考勤状态0-未考勤，1-正常打卡")
      private Integer clockInStatus;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
