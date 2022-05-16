package com.example.webchat.Controller;

import com.example.webchat.Entity.ResponseEntity;
import com.example.webchat.Mapper.UserMapper;
import com.example.webchat.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
/**
 * 登录
 */
public class LoginController {
    @Autowired
    LoginServer server;

    @PostMapping("/Login")
    public ResponseEntity Login(@RequestParam String admin,@RequestParam String password){
        String token= server.Login(admin,password);

        ResponseEntity<Map<String,String>> responseEntity = new ResponseEntity();

        Map<String,String> maps=new HashMap<>();

        if (token==null){
            responseEntity.setSuccess(false);
            maps.put("message","账号或者密码错误");

        }else {
            responseEntity.setSuccess(true);
            maps.put("token",token);
            maps.put("message","登录成功");
        }


        responseEntity.setBodys(maps);
        return responseEntity;
    }


    @PostMapping("/Regist")
    public ResponseEntity Regist(@RequestParam String email,@RequestParam String password){

        ResponseEntity<String> responseEntity=new ResponseEntity<>();
        responseEntity.setStatue(200);
        if (server.Regist(email,password)){
            responseEntity.setSuccess(true);
            responseEntity.setBodys("注册成功了");

         }else {
            responseEntity.setSuccess(false);
            responseEntity.setBodys("注册失败 账号已经存在了");
        }
        return  responseEntity;

    }

    /**
     * 获取个人详细信息
     * @return
     */
    public ResponseEntity<UserMapper> GetThenInfo(HttpServletRequest request){
        request.gett
    }
}
