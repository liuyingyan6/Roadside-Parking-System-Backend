package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author woniuxy
 * @since 2023-09-18
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "News对象", description = "")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "news_id", type = IdType.AUTO)
      private Integer newsId;

    private String newsTitle;

    private String newsContent;

    private Date newsTime;

    private String newsSource;

    private Integer fkCategoryId;

    private Integer views;

    @TableLogic
    private Integer logicDelete;

    @Version
    private Integer version;


}
