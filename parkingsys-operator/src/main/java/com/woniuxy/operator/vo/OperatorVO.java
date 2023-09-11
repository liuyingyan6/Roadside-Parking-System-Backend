package com.woniuxy.operator.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OperatorVO {

    private String operatorName;

    private String phone;

    private String names;

    private List<String> nameList;

    private String area;

    private Integer state;

    private String account;

    private String password;

}
