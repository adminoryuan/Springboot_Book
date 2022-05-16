package com.example.webchat;

import com.example.webchat.Untity.JwtUntity;
import com.example.webchat.server.LoginServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebchatApplicationTests {


    @Autowired
    LoginServer server;
    @Test
    void contextLoads() {
        System.out.println(server.Login("username","password"));
    }
    @Test
    void Add(){
        server.Regist("username","admin");
    }

    @Test
    void Webchat(){
    }
}
