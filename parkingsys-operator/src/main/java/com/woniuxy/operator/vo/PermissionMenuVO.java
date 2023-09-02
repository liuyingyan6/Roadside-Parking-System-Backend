package com.woniuxy.operator.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description: PermissionMenuVO
 * @Version 1.0
 */
@Data
public class PermissionMenuVO {

    private Long id;
    private String name;
    private String url;
    private List<PermissionMenuVO> children;
}
