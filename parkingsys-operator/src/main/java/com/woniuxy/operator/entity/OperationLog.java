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
 * 
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-02
 */
@Getter
@Setter
@ToString
  @TableName("operation_log")
@ApiModel(value = "OperationLog对象", description = "")
public class OperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户id，记录谁操作的")
      private Long userId;

      @ApiModelProperty("操作日志，1-add,2-update,3-delete")
      private Integer log;

      @ApiModelProperty("IP地址")
      private String ip;

      @ApiModelProperty("请求路径，区分哪个模块的增删改")
      private String url;

      @ApiModelProperty("创建时间")
      private Date createTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      private Integer logicDelete;


}
