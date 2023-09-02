package com.woniuxy.operator.entity;

import java.io.Serializable;
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
  @ApiModel(value = "China对象", description = "")
public class China implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private String name;

    private Integer pid;


}
