package com.woniuxy.inspector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String orderNumber;
    private String carNumber;
    private Date startTime;
    private Date endTime;
    private Integer status;
}
