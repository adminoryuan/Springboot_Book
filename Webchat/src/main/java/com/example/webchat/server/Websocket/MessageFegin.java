package com.example.webchat.server.Websocket;

import com.example.webchat.Entity.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public interface MessageFegin {

    @PostMapping("/SendMessage")
    public ResponseEntity<String> SendTextMessage(@RequestParam String email,@RequestParam String TextMeg);

}
