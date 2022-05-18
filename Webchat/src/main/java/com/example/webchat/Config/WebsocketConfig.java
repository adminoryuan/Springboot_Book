package com.example.webchat.Config;

import com.example.webchat.server.Websocket.WebsocketServere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@Configuration
public class WebsocketConfig implements WebSocketConfigurer {

    @Autowired
    WebsocketServere servere;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(servere,"imServer").setAllowedOrigins("*");
    }
    @Bean
   public WebsocketServere GetWebsockerServer(){
        return  servere;
    }
}
