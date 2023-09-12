package com.woniuxy.operator.entity;

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
 * @since 2023-09-05
 */
@Getter
@Setter
@ToString
  @TableName("user_feedback")
@ApiModel(value = "UserFeedback对象", description = "")
public class UserFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("自增主键")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty("反馈用户id")
      private Long userId;

      @ApiModelProperty("处理状态( 1 已处理  0 未处理)")
      private Integer state;
      @ApiModelProperty("反馈图片")
      private String imgSrc;
      @ApiModelProperty("反馈单号")
      private String feedbackOdd;
      @ApiModelProperty("反馈内容")
      private String feedbackText;
      @ApiModelProperty("处理结果")
      private String result;
      @ApiModelProperty("图片数量")
      private String imgCount;
      @ApiModelProperty("创建时间")
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty("更新时间")
      @TableField(fill = FieldFill.UPDATE)
      private Date updateTime;

      @ApiModelProperty("逻辑删除 1（true）已删除， 0（false）未删除")
      @TableLogic
      private Integer logicDelete;


}
