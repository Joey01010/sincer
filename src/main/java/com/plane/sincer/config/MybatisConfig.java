package com.plane.sincer.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public PageHelper getPageHelper(){
        return new PageHelper();
    }
}
