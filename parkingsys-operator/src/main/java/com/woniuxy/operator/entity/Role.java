package com.woniuxy.operator.entity;

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
 * @since 2023-09-05
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("自增主键")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("角色名称")
      private String name;

      @ApiModelProperty("创建时间")
      private Date createTime;

      @ApiModelProperty("更新时间")
      private Date updateTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      private Integer logicDelete;


}
