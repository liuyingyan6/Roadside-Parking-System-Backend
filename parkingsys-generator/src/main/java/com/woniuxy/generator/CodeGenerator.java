package com.woniuxy.generator;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.Collections;

/**
 * @Description: CodeGenerator
 * @Author 86176
 * @Date 2023/8/4 22:01
 * @Version 1.0
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //修改url username password
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/wn_parking?useSSL=false&charaterEncode=utf-8&serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("woniuxy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.ONLY_DATE).disableOpenDir().outputDir("D:\\code\\java"); // 指定输出目录
                }).packageConfig(builder -> {
                    builder.parent("com.woniuxy.operator") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\code\\resources\\mapper")); // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); // 允许使用Lombok注解
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
                    builder.addInclude("inspector_road"); // 设置需要生成的表名
                            // .addTablePrefix("t_"); // 设置过滤表前缀
                })
                .execute();

    }
}
