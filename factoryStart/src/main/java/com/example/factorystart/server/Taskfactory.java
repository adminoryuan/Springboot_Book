package com.example.factorystart.server;


import com.example.factorystart.bean.FactoryProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class Taskfactory {

    public Taskfactory(){
        System.out.printf("创建了对象\n");
    }
    @Autowired
    FactoryProperties properties;

    public void Sumbit(Runnable runnable){
        System.out.println(properties.getMaxCore());
        System.out.printf("你提交了一个任务");
    }
}

