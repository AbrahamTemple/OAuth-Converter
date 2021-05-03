package com.spring.vongbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.vongbase.mapper")
public class VongBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(VongBaseApplication.class, args);
    }

}
