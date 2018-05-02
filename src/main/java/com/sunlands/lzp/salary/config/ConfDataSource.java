package com.sunlands.lzp.salary.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ConfDataSource {
    @Autowired
    DataProperties dataProperties;
    @Bean
    public javax.sql.DataSource getDataSource(){
        DruidDataSource druidDataSource =new DruidDataSource();
        druidDataSource.setLoginTimeout(20);
        druidDataSource.setTestWhileIdle(false);
        druidDataSource.setDriverClassName(dataProperties.getDriverClassName().trim());
        druidDataSource.setUrl(dataProperties.getUrl().trim());
        druidDataSource.setUsername(dataProperties.getUsername().trim());
        druidDataSource.setPassword(dataProperties.getPassword().trim());
        System.out.println(dataProperties.getDriverClassName().trim());
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
}
