package com.example.webchat.server.impl;

import com.example.webchat.Entity.CliMessageEntity;
import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.server.IHandleFunc;
import com.example.webchat.server.IHandleMessage;
import com.example.webchat.server.LoginServer;
import com.example.webchat.server.ResultServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * 处理消息
 */
@Primary
@Component
public class HandleMessageImpl implements IHandleMessage {

    @Autowired
    JsonUntity untity;

    @Autowired
    LoginServer Server;

    @Autowired
    IHandleFunc Ifunc;

    /**
     * 中转消息
     */
    public void Handle(String message, WebSocketSession session){
        String currUser="";
        try {
            CliMessageEntity squence = untity.<CliMessageEntity>Squence(message, CliMessageEntity.class);
            // 不是登录消息 需要查验token
            if (squence.getMegType()!=1){

                currUser=Server.CheckToken(squence.getToken());

                 if(currUser==null){
                     session.sendMessage(new TextMessage(untity.Serialize(ResultServer.ServerError(squence.getMegType()))));
                     return;
                 }

            }

            //根据消息类型对消息进行处理

            switch (squence.getMegType()){
                case 1:
                    String login = Ifunc.Login(squence.getPlayLoad());

                    session.sendMessage(new TextMessage(login));

                    break;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
