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
 * 角色与菜单、接口权限的对应关系
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-05
 */
@Getter
@Setter
@ToString
  @TableName("role_url_permission")
@ApiModel(value = "RoleUrlPermission对象", description = "角色与菜单、接口权限的对应关系")
public class RoleUrlPermission implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("自增主键")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("权限id")
      private Long urlPermissionId;

      @ApiModelProperty("角色id")
      private Long roleId;

      @ApiModelProperty("创建时间")
      private Date createTime;

      @ApiModelProperty("更新时间")
      private Date updateTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      private Integer logicDelete;


}
