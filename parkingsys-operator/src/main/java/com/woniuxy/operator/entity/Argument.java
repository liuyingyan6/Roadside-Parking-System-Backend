package com.woniuxy.operator.entity;

import java.io.Serializable;
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
 * @since 2023-09-08
 */
@Getter
@Setter
@ToString
  @ApiModel(value = "Argument对象", description = "")
public class Argument implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vpayUserName;

    private String vpayId;

    private String vpayAccount;

    private String vpayPassword;

    private String vpayUserPassword;

    private String alipayName;

    private String alipayUserId;

    private String alipayMdcode;

    private String alipayPrivateCode;

    private String alipayPublicCode;

    private String alipayFormat;

    private String alipayCharacterCode;

    private String alipayType;

    private String mesId;

    private String mesName;

    private String mesPassword;

    private Long id;


}
