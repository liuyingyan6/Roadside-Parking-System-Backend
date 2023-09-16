package com.woniuxy.operator.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountVO {


    private Long carNum;
    private Long orderNum;
    private Long expenseMoney;
    private Long notPayOrder;
    private Long notExpenseMoney;
    private List<AccountVO> accountVO;
}
