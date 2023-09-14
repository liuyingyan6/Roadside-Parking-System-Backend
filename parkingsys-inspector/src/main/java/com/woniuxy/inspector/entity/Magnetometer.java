package com.woniuxy.inspector.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-09-13
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Magnetometer对象", description = "")
public class Magnetometer implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("地磁编号")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("地磁名称")
      private String name;

      @ApiModelProperty("绑定泊位id")
      private Long parkingId;

      @ApiModelProperty("地磁状态：0-在线，1-离线，2-未激活")
      private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
