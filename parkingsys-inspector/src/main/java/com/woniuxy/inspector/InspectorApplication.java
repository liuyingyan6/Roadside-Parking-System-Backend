package com.woniuxy.inspector;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.woniuxy.inspector.mapper")
public class InspectorApplication {
    public static void main(String[] args) {
        SpringApplication.run(InspectorApplication.class,args);
    }
}
