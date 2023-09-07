package com.woniuxy.operator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String orderNumber;
}
