package com.example.webchat.Dao;

import org.springframework.stereotype.Component;

@Component
public class LoginDao {

    /**
     * 判断是否登录成功
     * @param admin
     * @param password
     * @return
     */
    public boolean IsLoginOk(String admin ,String password){

        return  admin.equals("admin");

    }
}
