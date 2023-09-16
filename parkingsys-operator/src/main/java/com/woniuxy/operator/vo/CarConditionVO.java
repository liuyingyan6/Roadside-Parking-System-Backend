package com.woniuxy.operator.vo;


import javax.xml.crypto.Data;

@lombok.Data
public class CarConditionVO {


    private Long id;

    private String carNumber;
    private String carType;
    private Long orderNum;
    private Long notPayOrder;
    private Long expenseMoney;
    private Long notExpenseMoney;
    private Data createTime;


}
