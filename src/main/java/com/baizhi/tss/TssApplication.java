package com.baizhi.tss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.baizhi.tss.dao")
@SpringBootApplication
public class TssApplication {

    public static void main(String[] args) {
        SpringApplication.run(TssApplication.class, args);
    }

}

