package com.lingxue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lingxue.mapper")
@SpringBootApplication
public class ManagerApplication{

    public static void main(String[] args){
        SpringApplication.run(ManagerApplication.class, args);
    }

}
