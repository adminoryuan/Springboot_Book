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


    public String Login(String admin,String password){
        Wrapper<UserEntity> Wrapp=new QueryWrapper<UserEntity>().eq("admin",admin).lt("password",password);

        UserEntity userEntity = mapper.selectOne(Wrapp);


        if (userEntity!=null){
            return JwtUntity.DecodingJwt(admin);
        }
        return null;
    }

    public String CheckToken(String token){
        return check.Check(token);
    }

}
