package com.example.webchat.server.Websocket;

import com.example.webchat.Entity.CliMessageEntity;
import com.example.webchat.Entity.ResultMessageEntity;
import com.example.webchat.Untity.JsonUntity;
import com.example.webchat.server.OnLineServer;
import com.example.webchat.server.Websocket.IHandleFunc;
import com.example.webchat.server.Websocket.IHandleMessage;
import com.example.webchat.server.LoginServer;
import com.example.webchat.server.Websocket.ResultServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 处理消息
 */

@Component
public class HandleMessageImpl implements IHandleMessage {

    @Autowired
    JsonUntity untity;

    @Autowired
    LoginServer Server;

    @Autowired
    IHandleFunc Ifunc;

    @Autowired
    OnLineServer OnLineServer;

    /**
     * 中转消息
     */
    public void Handle(String message, WebSocketSession session){
        String currUser="";
        try {
                CliMessageEntity squence = untity.<CliMessageEntity>Squence(message, CliMessageEntity.class);

                currUser=Server.CheckToken(squence.getToken());

                if(currUser==null){
                     session.sendMessage(new TextMessage(untity.Serialize(ResultServer.ServerError(squence.getMegType()))));
                     return;
                 }


                switch (squence.getMegType()){
                    case 1:OnLineServer.AddUser(currUser,session);
                        break;
                    case 2:
                        System.out.println("查看全部在线人数");
                        //查询在线人数
                        ResultMessageEntity<Set<String>> resultMessage=new ResultMessageEntity<>();
                        resultMessage.setIsOk(true);
                        resultMessage.setMegType(2);
                        resultMessage.setBody(OnLineServer.getAllUser());
                        session.sendMessage(new TextMessage(untity.Serialize(resultMessage)));
                        break;
                    case 3:
                        /**
                         * 发送消息
                         */
                        Map<String,String> meg=squence.getPlayLoad();
                        System.out.println(meg.keySet().size());
                        if (meg.getOrDefault("isMass","").equals("1")){
                            String bodys=meg.getOrDefault("meg","");
                            Map<String,String> maps=new HashMap<>();

                            maps.put("sendUser",currUser);
                            maps.put("bodys",bodys);

                            ResultMessageEntity<Map<String,String>> res=new ResultMessageEntity<>();
                            res.setIsOk(true);
                            res.setBody(maps);
                            res.setMegType(3);
                            OnLineServer.Mass(untity.Serialize(res));
                        }
                        break;
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
