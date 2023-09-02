package com.woniuxy.operator.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Description: SwaggerConfig
 * @Date 2023/8/24 19:23
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 创建在线文档摘要对象
     * @return
     */
    @Bean // 创建对象，加入ioc容器
    public Docket createDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        // 设置文档摘要信息：标题、版本、描述
        docket.apiInfo(new ApiInfoBuilder()
                .title("智慧停车系统")
                .version("1.0")
                .description("Api描述")
                .build()
        );
        // 扫描的API路径
        docket.select()         .apis(RequestHandlerSelectors.basePackage("com.woniuxy.operator.controller"))
                // 设置对指定路径下的任意类生成文档
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
