package com.sunlands.lzp.salary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class ConfiBeans {

    @Autowired
    Environment environment;
    @Bean
    public SimpleMailMessage getSimpleMailMessage(){
        return new SimpleMailMessage();
    }

}
