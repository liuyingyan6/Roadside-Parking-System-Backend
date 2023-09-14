package com.woniuxy.inspector.entity;

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
 * @since 2023-09-13
 */
@Getter
@Setter
@ToString
  @TableName("feedback_img")
@ApiModel(value = "FeedbackImg对象", description = "")
public class FeedbackImg implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Long inspectorFeedbackId;

    private Long userFeedbackId;

    private String imgUrl;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
