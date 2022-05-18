package com.example.webchat.server;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OnLineServer {

    private static Map<String, WebSocketSession> OnLineMap=new ConcurrentHashMap<>();


    public void AddUser(String user,WebSocketSession session){
        OnLineMap.put(user,session);
    }

    public WebSocketSession GetUser(String user,WebSocketSession session){
        return session;
    }

    /**
     * 获取全部在线用户
     * @return
     */
    public Set<String> getAllUser(){

        return OnLineMap.keySet();
    }
    public void Mass(String meg) throws IOException {
        TextMessage textMessage = new TextMessage(meg);
        for (WebSocketSession value : OnLineMap.values()) {

            value.sendMessage(textMessage);
        }
    }
}
