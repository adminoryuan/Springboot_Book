package com.example.webchat.server.Websocket;

//import org.springframework.web.socket.WebSocketSession;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;


public interface IHandleMessage {

    void Handle(String body, WebSocketSession session);
}
