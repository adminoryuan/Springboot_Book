package com.example.webchat.server;

import com.example.webchat.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录Server
 */
@Component
public class LoginServer {

    @Autowired
    LoginDao _dao;


    public boolean Login(String admin,String password){
       return  _dao.IsLoginOk(admin,password);
    }

}
