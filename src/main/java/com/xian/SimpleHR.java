package com.xian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.xian.mapper")
@SpringBootApplication
@EnableRabbit
public class SimpleHR {

    public static void main(String[] args) {

        System.out.println("hello world");
        SpringApplication.run(SimpleHR.class, args);
    }

}
