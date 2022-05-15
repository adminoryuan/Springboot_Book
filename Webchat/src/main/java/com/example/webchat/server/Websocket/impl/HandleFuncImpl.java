package com.example.webchat.server.Websocket.impl;

import com.example.webchat.Entity.ResultMessageEntity;
import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.server.Websocket.IHandleFunc;
import com.example.webchat.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HandleFuncImpl implements IHandleFunc {



    @Autowired
    JsonUntity Juntity;

    @Autowired
    LoginServer Server;
    @Override
    public String Login(String playLoad) {

        try {
            UserEntity squence = Juntity.<UserEntity>Squence(playLoad, UserEntity.class);
            String token=Server.Login(squence.getAdmin(),squence.getPassword());

            ResultMessageEntity<String> resultMessageEntity=new ResultMessageEntity<>();
            if (token!=null){
                /***
                 * 返回登录成功响应消息
                 */
                resultMessageEntity.setMegType(1);
                resultMessageEntity.setIsOk(true);
                resultMessageEntity.setBody(token);
            }else{
                resultMessageEntity.setIsOk(false);
            }
            return Juntity.Serialize(resultMessageEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "服务器错误";

    }

    @Override
    public void DispMessage(String playLoad) {

    }
}
