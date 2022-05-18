package com.example.webchat.server.Websocket;

import com.example.webchat.server.OnLineServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebsocketServere implements WebSocketHandler {




    @Autowired
    HandleMessageImpl HandleImp;




    /**
     * 连接时触发
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

    /**
     * 收到消息时触发
     * @param session
     * @param message
     * @throws Exception
     */

    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String Body= message.getPayload().toString();

        HandleImp.Handle(Body,session);

    }

    /**
     * 发生异常时回调
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    /**
     * 关闭链接时
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    /**
     * 是否支持消息分片
     * @return
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
