package com.woniuxy.operator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TokenResponse
 * @Date 2023/8/30 14:25
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;//短令牌
}
