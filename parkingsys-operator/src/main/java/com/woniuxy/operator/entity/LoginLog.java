package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
  @TableName("login_log")
@ApiModel(value = "LoginLog对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

      @TableField("user_id")
    private Long userId;

      @ApiModelProperty("0-登录，1-退出")
      private Integer log;

    private String ip;
    @TableField("create_time")
      @ApiModelProperty("日志创建时间")
      private Date createTime;
    @TableField("logic_delete")
      @ApiModelProperty("逻辑删除")
      private Integer logicDelete;

      @ApiModelProperty("地址")
      private String location;

      @ApiModelProperty("浏览器")
      private String browser;


}
