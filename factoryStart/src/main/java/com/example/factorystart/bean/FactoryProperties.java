package com.example.factorystart.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("hy.task")
@Data
public class FactoryProperties {

  private   int MaxCore;
   private int MaxThread;



}
