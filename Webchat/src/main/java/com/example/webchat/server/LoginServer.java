package com.example.webchat.server;

import com.example.webchat.Dao.LoginDao;
import com.example.webchat.Untity.IdentityCheck;
import com.example.webchat.Untity.JwtUntity;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录Server
 */
@Component
public class LoginServer {

    @Autowired
    LoginDao _dao;

    @Autowired
    IdentityCheck check;


    public String Login(String admin,String password){
       if (_dao.IsLoginOk(admin,password)){
           return JwtUntity.EncoderJwt(admin);
       }
       return null;
    }

    public String CheckToken(String token){
        return check.Check(token);
    }

}
