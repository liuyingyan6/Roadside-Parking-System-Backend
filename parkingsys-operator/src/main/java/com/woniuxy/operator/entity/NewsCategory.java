package com.woniuxy.operator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

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
  @TableName("news_category")
@ApiModel(value = "NewsCategory对象", description = "")
public class NewsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "category_id", type = IdType.AUTO)
      private Integer categoryId;

    private String newsCategory;


}
