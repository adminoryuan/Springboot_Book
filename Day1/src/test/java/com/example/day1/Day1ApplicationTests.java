package com.example.day1;

import com.example.day1.Service.RandClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Day1ApplicationTests {

    @Autowired
    RandClass r1;

    @Autowired
    RandClass r2;
    @Test
    void contextLoads() {
        System.out.println(r1.getRan());
        System.out.println(r2.getRan());
    }

}
