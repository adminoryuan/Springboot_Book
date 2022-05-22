package com.example.webchat;

import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.Untity.httpUntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class untityTest {

    @Autowired
    httpUntity u;

    @Autowired
    JsonUntity jsonUntity;
    @Test
    void Post() throws JsonProcessingException {
        StringBuilder builder=new StringBuilder();
        Map<String,String> maps=new HashMap<>();
        maps.put("admin","123123");
        maps.put("password","asdasd");


        String s = u.DoPost("http://127.0.0.1:9000/Login", jsonUntity.Serialize(maps)+"\r\n\r\n");
        System.out.println(s);
    }
}
