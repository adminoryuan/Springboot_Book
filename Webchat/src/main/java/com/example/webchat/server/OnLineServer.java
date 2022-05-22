package com.example.webchat.server;

import com.example.webchat.Untity.RedisUntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
//本地保存的用户与长链接的对应关系
public class OnLineServer {

    @Autowired
    RedisUntity untity;

    private static Map<String, WebSocketSession> OnLineMap=new ConcurrentHashMap<>();


    public void AddUser(String user,WebSocketSession session){
        OnLineMap.put(user,session);
    }

    public WebSocketSession GetUser(String user){
        return OnLineMap.get(user);
    }

    /**
     * 获取全部在线用户
     * @return
     */
    public Set<Object> getAllUser(){

        return  untity.getHashKeySet("OnLineUser");
    }

    /*
    * 私发消息给用户
    */
    public boolean sendTextUser(String user,String Message){
        String Node= untity.getHashCache("OnLineUser",user).toString();

        return true;

    }


    public void Mass(String meg) throws IOException {
        TextMessage textMessage = new TextMessage(meg);
        for (WebSocketSession value : OnLineMap.values()) {

            value.sendMessage(textMessage);
        }
    }
}
