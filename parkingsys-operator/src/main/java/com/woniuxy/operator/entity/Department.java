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
 * @since 2023-09-06
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Department对象", description = "")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

      private Long id;

      @ApiModelProperty("部门名称")
      private String departmentName;

      @ApiModelProperty("所在城市")
      private String departmentCity;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
