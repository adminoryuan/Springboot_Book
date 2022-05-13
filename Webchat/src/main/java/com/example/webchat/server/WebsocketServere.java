package com.example.webchat.server;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebsocketServere implements WebSocketHandler {


    private Map<String,WebSocketSession> OnLineMap=new ConcurrentHashMap<>();


    /**
     * 返回当前在线人数
     * @return
     */
    public int GetOnlineProson(){
        return OnLineMap.size();

    }



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
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String Body= message.getPayload().toString();


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
