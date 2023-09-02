package com.woniuxy.operator.vo;

import lombok.AllArgsConstructor;
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
public class PageVO<T> {

    private Long total;
    private List<T> records;
}
