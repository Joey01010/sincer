package com.plane.sincer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.plane.sincer.mapper")
public class SincerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SincerApplication.class, args);
    }

}
