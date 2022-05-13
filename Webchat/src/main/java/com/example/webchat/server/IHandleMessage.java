package com.example.webchat.server;

import org.springframework.web.socket.WebSocketSession;

public interface IHandleMessage {

    void Handle(String body, WebSocketSession session);
}
