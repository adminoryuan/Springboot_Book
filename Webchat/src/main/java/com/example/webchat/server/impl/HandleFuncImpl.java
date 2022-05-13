package com.example.webchat.server.impl;

import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.server.IHandleFunc;
import com.example.webchat.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class HandleFuncImpl implements IHandleFunc {

    @Autowired
    JsonUntity Juntity;

    @Autowired
    LoginServer Server;
    @Override
    public void Login(String playLoad) {

        try {
            UserEntity squence = Juntity.<UserEntity>Squence(playLoad, UserEntity.class);
            Server.Login(squence.getAdmin(),squence.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void DispMessage(String playLoad) {

    }
}
