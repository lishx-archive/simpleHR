package com.xian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@MapperScan("com.xian.mapper")
@SpringBootApplication
public class SimpleHR {

    public static void main(String[] args) {

        SpringApplication.run(SimpleHR.class, args);
    }

}
