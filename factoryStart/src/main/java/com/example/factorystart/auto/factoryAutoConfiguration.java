package com.example.factorystart.auto;

import com.example.factorystart.bean.FactoryProperties;
import com.example.factorystart.server.Taskfactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(FactoryProperties.class)
public class factoryAutoConfiguration {


    @ConditionalOnMissingBean(Taskfactory.class)
    @Bean
    public Taskfactory getTaskFactory(){
        System.out.printf("加载自动发配置");
        return new Taskfactory();
    }


}
