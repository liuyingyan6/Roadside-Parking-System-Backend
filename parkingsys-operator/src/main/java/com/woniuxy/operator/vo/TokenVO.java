package com.woniuxy.operator.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TokenVO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenVO {

    private String accessToken;//短令牌
    private String refreshToken;//长令牌
    private Long id;//登录者的ID
    private String currentUser;//登录者的名称
}
