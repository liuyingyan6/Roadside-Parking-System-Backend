package com.woniuxy.inspector.entity;

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
  @ApiModel(value = "Inspector对象", description = "")
public class Inspector implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

      @ApiModelProperty("巡检员名称")
      private String name;

      @ApiModelProperty("手机号")
      private String phone;

    private String password;

    private String url;

      @ApiModelProperty("巡检员状态")
      private Integer state;

      @ApiModelProperty("执勤表id")
      private Long clockInId;

    private Long chargeId;

      @ApiModelProperty("设备id")
      private Long pdaId;

      @ApiModelProperty("地址id")
      private Long chinaId;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
