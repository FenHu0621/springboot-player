package com.lening;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lening.mapper"})
public class SpringPlayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPlayerApplication.class, args);
    }

}
