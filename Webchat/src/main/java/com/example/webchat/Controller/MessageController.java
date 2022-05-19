package com.example.webchat.Controller;

import com.example.webchat.Entity.ResponseEntity;
import com.example.webchat.server.OnLineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@RequestMapping("/Message")
public class MessageController {


    @Autowired
    OnLineServer onLineServer;


    @PostMapping("/SendMessage")
    public ResponseEntity<String> SendTextMessage(@RequestParam String email,String TextMeg) throws IOException {
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        responseEntity.setStatue(200);
        responseEntity.setSuccess(true);

        WebSocketSession curr = onLineServer.GetUser(email);
        if (curr==null){
            responseEntity.setSuccess(false);
            responseEntity.setBodys("刚用户下线或者不存在");
        }else{
            curr.sendMessage(new TextMessage(TextMeg));
            responseEntity.setBodys("发送成功");
        }
        return responseEntity;
    }

    @PostMapping("/Mass")
    public ResponseEntity<String> SendMassTextMeeage(String TextMeg) throws IOException {
        onLineServer.Mass(TextMeg);
        ResponseEntity<String> responseEntity=new ResponseEntity<>();
        responseEntity.setSuccess(true);
        responseEntity.setBodys("发送成功");
        return  responseEntity;

    }

}
