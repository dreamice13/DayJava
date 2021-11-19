package com.dayup.dreamhub.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：dreamice
 * @date ：Created in 2021/11/18 18:11
 * @description：MybatisPlus配置类
 * @modified By：
 * @version: 1.0$
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.dayup.dreamhub.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        return mybatisPlusInterceptor;
    }
}
