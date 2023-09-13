package com.woniuxy.operator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.woniuxy.operator.mapper")
public class OperatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperatorApplication.class,args);
    }
}
