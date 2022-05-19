package com.example.webchat;

import com.example.webchat.Entity.CliMessageEntity;
import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.Untity.RedisUntity;
import com.example.webchat.server.LoginServer;
import com.example.webchat.server.Websocket.impl.HandleMessageImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class WebchatApplicationTests {

    @Autowired
    HandleMessageImpl imp;
    @Autowired
    LoginServer server;

    @Autowired
    JsonUntity untity;
    @Autowired
    RedisUntity redisUntity;
    @Test
    void contextLoads() {
        System.out.println(server.Login("username","password"));
    }
    @Test
    void Add(){
        server.Regist("username","admin");
    }

    @Test
    void Webchat() throws IOException {
        UserEntity entity=new UserEntity();
        CliMessageEntity entity1 = new CliMessageEntity();
        entity1.setMegType(1);
//
        String data="{\"megType\":1,\"token\":\"eyJhbGciOiJIUzI1NiJ9.eyJhZG1pbiI6ImxsIiwiZXhwIjoxNjUyODUyODg3fQ.PiGIw4xxr8MwMDkf9BdQ6m4fc19c8XjVy2yuGU6dwys\",\"playLoad\":\"hahaha\"}";

        System.out.printf(untity.Serialize(entity1));


        CliMessageEntity a= untity.Squence(data,CliMessageEntity.class);


    }

    @Test
    void RedisTest(){
        redisUntity.add("get","adqwe");
    }
}
