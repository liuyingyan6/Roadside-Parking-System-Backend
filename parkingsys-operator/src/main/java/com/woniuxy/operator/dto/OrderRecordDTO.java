package com.woniuxy.operator.dto;


import lombok.Data;

@Data
public class OrderRecordDTO {

    private String orderNumber;
    private String carNum;
    private Integer status;
}
