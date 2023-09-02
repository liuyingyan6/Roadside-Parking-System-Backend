package com.woniuxy.operator.entity;

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
 * @since 2023-09-02
 */
@Getter
@Setter
@ToString
  @TableName("parking_ai")
@ApiModel(value = "ParkingAi对象", description = "")
public class ParkingAi implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

      @ApiModelProperty("停车场id")
      private Integer parkingId;

      @ApiModelProperty("泊位编号，类似A-112")
      private String number;

      @ApiModelProperty("0-有车，1-无车")
      private Integer parkingStatus;

      @ApiModelProperty("地磁状态：0-在线，1-离线，2-未激活")
      private Integer parkingAiStatus;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
