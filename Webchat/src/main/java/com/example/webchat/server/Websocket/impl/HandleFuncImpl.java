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
    public void DispMessage(String playLoad) {

    }
}
