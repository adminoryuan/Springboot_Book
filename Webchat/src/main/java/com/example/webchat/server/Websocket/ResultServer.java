package com.example.webchat.server.Websocket;

import com.example.webchat.Entity.ResultMessageEntity;
import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.Untity.JwtUntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 封装了一些常用的消息
 */
public class ResultServer {




    public static ResultMessageEntity<String> ServerError(int typeId){

        ResultMessageEntity<String> resultMessageEntity=new ResultMessageEntity<>();
        resultMessageEntity.setIsOk(false);
        resultMessageEntity.setBody("服务器错误");
        return resultMessageEntity;
    }
    public static ResultMessageEntity<String> Unauthorized(int typeId){
        ResultMessageEntity<String> resultMessageEntity=new ResultMessageEntity<>();

        resultMessageEntity.setIsOk(false);

        resultMessageEntity.setBody("未授权");
        return resultMessageEntity;

    }

}
