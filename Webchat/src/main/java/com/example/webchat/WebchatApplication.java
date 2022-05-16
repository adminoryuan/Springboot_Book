package com.example.webchat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.webchat.Mapper")
public class WebchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebchatApplication.class, args);
    }

}
