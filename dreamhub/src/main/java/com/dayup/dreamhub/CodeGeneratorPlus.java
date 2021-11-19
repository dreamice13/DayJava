package com.dayup.dreamhub;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：Dreamice
 * @date ：Created in 2021/11/19 14:21
 * @description：代码自动生成
 * @modified By：
 * @version: 1.0.0$
 */
public class CodeGeneratorPlus {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dreamhub?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "root123";
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(url, username, password)
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        // .author(scanner.apply("请输入作者名称？"))
                        .author("Dreamice")
                        .outputDir(projectPath + "/src/main/java")  // 指定输出目录 默认值: windows:D://  linux or mac : /tmp
                        // .enableSwagger()    // 开启 swagger 模式	默认值:false
                        .disableOpenDir()   // 禁止打开输出目录	默认值:true
                        .fileOverride())    // 覆盖已生成文件	默认值:false
                // 包配置
                .packageConfig((scanner, builder) -> builder
                        // .parent(scanner.apply("请输入包名？"))
                        .parent("com.dayup.dreamhub")
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
