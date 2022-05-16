package com.example.webchat.Untity;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt的工具类
 */
@Component
public class JwtUntity {

    public  String PrivateKey="jaslkdjalksjdlaksjdlkasjdlkajsldkjas";

    /**
     * 生成jwt
     * @param admin
     * @return
     */
    public  String EncoderJwt(String admin){
        JwtBuilder Jwtbuilder = Jwts.builder();
        Map<String,Object> hashMap=new HashMap<>();
        hashMap.put("admin",admin);
        return Jwtbuilder.setSubject("Websocketerver.")
                .setIssuedAt(new Date())
                .setId("1")
                .setClaims(hashMap)
                .setExpiration(new Date(System.currentTimeMillis()+60*10000))
                .signWith(SignatureAlgorithm.HS256,PrivateKey).compact();
    }

    /**
     * 从jwt中解析出用户名
     * @param jwt
     * @return
     */
    public  String DecodingJwt(String jwt){
        JwtParser jwtParser=Jwts.parser();

        jwtParser.setSigningKey(PrivateKey);
        try {

            Jws<Claims> headerClaimsJwt = jwtParser.parseClaimsJws(jwt);
            return headerClaimsJwt.getBody().get("admin").toString();

        }catch (Exception e){
            return null;
        }
    }
}
