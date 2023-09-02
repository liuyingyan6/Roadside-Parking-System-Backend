package com.woniuxy.operator.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description: AuthorizationDTO
 * @Date 2023/8/31 20:00
 * @Version 1.0
 */
@Data
public class AuthorizationDTO {

    private Long id;
    private String name;
    private List<Long> permissionData;
}
