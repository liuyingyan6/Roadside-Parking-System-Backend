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
 * @since 2023-09-07
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Information对象", description = "")
public class Information implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("平台名称")
      private String name;

      @ApiModelProperty("url")
      private String logo;

      @ApiModelProperty("客服电话")
      private String serviceTel;

      @ApiModelProperty("客服邮箱")
      private String serviceEmail;

      @ApiModelProperty("版权")
      private String copyright;

      @ApiModelProperty("用户协议")
      private String userAgreement;

      @ApiModelProperty("关于我们（平台介绍）")
      private String introduce;

    private Date createTime;

    private Date updateTime;

    private Integer logicDelete;


}
