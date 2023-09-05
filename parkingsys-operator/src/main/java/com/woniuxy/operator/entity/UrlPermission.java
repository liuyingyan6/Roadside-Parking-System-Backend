package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 菜单和接口权限定义
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Getter
@Setter
@ToString
  @TableName("url_permission")
@ApiModel(value = "UrlPermission对象", description = "菜单和接口权限定义")
public class UrlPermission implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("自增主键")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("权限名称")
      private String name;

      @ApiModelProperty("权限对应的url")
      private String url;

      @TableField("parent_id")
      @ApiModelProperty("上级菜单id")
      private Long parentId;
  @TableField("url_type")
      @ApiModelProperty("菜单权限还是接口权限：1-菜单权限，2-接口权限")
      private String urlType;
  @TableField("create_time")
      @ApiModelProperty("创建时间")
      private Date createTime;
  @TableField("update_time")
      @ApiModelProperty("更新时间")
      private Date updateTime;
  @TableField("logic_delete")
      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      private Integer logicDelete;


}
