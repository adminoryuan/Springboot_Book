package com.example.day1.Config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * 默认配置类
 */
@Configurable
public class defulatConfig {

    @Bean
    public TaskFactory getTaskFactory(){
        return new TaskFactory();
    }
}
