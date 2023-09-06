package com.woniuxy.operator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: OperatorApplication
 * @Version 1.0
 */
@MapperScan("com.woniuxy.operator.mapper")
@SpringBootApplication
public class OperatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperatorApplication.class,args);
    }
}
