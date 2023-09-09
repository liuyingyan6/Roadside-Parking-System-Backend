package com.woniuxy.operator.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @Description: ManagerRoleDTO
 * @Version 1.0
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerRoleDTO {

    private String name;
    private String account;
    private String password;
    private String telephone;
    private Long roleId;
    private Long departmentId;
}
