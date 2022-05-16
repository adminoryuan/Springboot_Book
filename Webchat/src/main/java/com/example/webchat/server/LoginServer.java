package com.example.webchat.server;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Mapper.UserMapper;
import com.example.webchat.Untity.IdentityCheck;
import com.example.webchat.Untity.JwtUntity;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.apache.catalina.mapper.WrapperMappingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录Server
 */
@Component
public class LoginServer {

    @Autowired
    UserMapper mapper;

    @Autowired
    IdentityCheck check;

    @Autowired
    JwtUntity untity;

    public String Login(String admin,String password){
        System.out.printf(admin);
        System.out.printf(password);

        Wrapper<UserEntity> Wrapp=new QueryWrapper<UserEntity>().eq("username",admin).eq("password",password);


        UserEntity userEntity = mapper.selectOne(Wrapp);

        if (userEntity!=null){

            return untity.EncoderJwt("ll");
        }
        return null;
    }

    public String CheckToken(String token){
        return check.Check(token);
    }


    /**
     * 注册用户
     * @return
     */
    public boolean Regist(String email,String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setUserName(email);
        userEntity.setAge(10);
        //userEntity.setUserName(admin);

        return mapper.insert(userEntity)>0;

    }
}
