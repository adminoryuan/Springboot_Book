package com.example.webchat.Untity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 对身份进行校验
 */
@Component
public class IdentityCheck {


    public String Check(String token){
        return JwtUntity.DecodingJwt(token);
    }
}
