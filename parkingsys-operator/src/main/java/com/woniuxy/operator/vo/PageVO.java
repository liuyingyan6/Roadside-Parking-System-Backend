package com.woniuxy.operator.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: PageVO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageVO<T> {

    private Long total;    //总记录数
    private List<T> records;  //查询结果
}
