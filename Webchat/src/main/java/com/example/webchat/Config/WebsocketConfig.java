package com.example.webchat.Config;

import com.example.webchat.server.WebsocketServere;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

public class WebsocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebsocketServere(),"/imServer").setAllowedOrigins("*");
    }
    @Bean
   public WebsocketServere GetWebsockerServer(){
        return  new WebsocketServere();
    }
}
