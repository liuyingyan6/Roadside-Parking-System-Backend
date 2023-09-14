package com.woniuxy.inspector.entity;

import com.baomidou.mybatisplus.annotation.*;

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
  @TableName("inspector_feedback")
@ApiModel(value = "InspectorFeedback对象", description = "")
public class InspectorFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("自增主键")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("反馈单号")
      private Long feedbackId;

      @ApiModelProperty("反馈用户id")
      private Long inspectorId;

      @ApiModelProperty("地磁编号&所属泊位")
      private Long parkingId;

      @ApiModelProperty("处理状态")
      private Integer state;

      @ApiModelProperty("反馈图片")
      private Integer imgId;

      @ApiModelProperty("反馈信息")
      private String information;

      @ApiModelProperty("处理结果")
      private String resultInformation;

  @TableField(fill = FieldFill.INSERT)
      @ApiModelProperty("创建时间")
      private Date createTime;

      @ApiModelProperty("更新时间")
      private Date updateTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      private Integer logicDelete;


}