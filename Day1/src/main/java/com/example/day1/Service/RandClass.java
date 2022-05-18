package com.example.day1.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class RandClass {
    private int ran=new Random().nextInt(100);

    public int getRan() {
        return ran;
    }
}
