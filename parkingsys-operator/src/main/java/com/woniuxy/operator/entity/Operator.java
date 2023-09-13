package com.woniuxy.operator.entity;

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
 * @since 2023-09-10
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Operator对象", description = "")
public class Operator implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

      @ApiModelProperty("运维员名称")
      private String operatorName;

    private String account;

    private String password;

      @ApiModelProperty("手机号")
      private String phone;

      @ApiModelProperty("路段id")
      private Long roadId;

      @ApiModelProperty("所属分区")
      private String area;

      @ApiModelProperty("运营员状态")
      private Integer state;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
