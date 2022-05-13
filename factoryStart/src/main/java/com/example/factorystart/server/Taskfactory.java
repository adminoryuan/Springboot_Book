package com.example.factorystart.server;


import com.example.factorystart.bean.FactoryProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Taskfactory {

    class MyFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread();
        }
    }

    private ThreadPoolExecutor executor;
    public Taskfactory(){
        System.out.printf("创建了对象\n");
        executor=new ThreadPoolExecutor(
               properties.getThreadCore(),
                properties.getMaxThread(),
                20,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(properties.getMaxThread()),
                new MyFactory()
        );
    }

    @Autowired
    FactoryProperties properties;

    public void Sumbit(Runnable runnable){
        executor.execute(runnable);
        System.out.printf("你提交了一个任务");
    }
}

