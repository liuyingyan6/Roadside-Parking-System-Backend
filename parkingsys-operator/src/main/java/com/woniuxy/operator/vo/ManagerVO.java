package com.woniuxy.operator.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: ManagerVO
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerVO {

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("手机号")
    private String telephone;

    @ApiModelProperty("账户是否锁定（0-正常，1-停用）")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

}
