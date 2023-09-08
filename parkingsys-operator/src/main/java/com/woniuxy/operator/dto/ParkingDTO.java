package com.woniuxy.operator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDTO {
    private Long id;
    private String number;
    private String name;

    private Integer magnetometerId;
    private String pdaName;
    private Date pdaTime;

    private Integer status;
    private Date createTime;
}
