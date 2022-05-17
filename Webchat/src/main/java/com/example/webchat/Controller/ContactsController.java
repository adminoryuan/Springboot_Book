package com.example.webchat.Controller;


import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Entity.UserFriendVo;
import com.example.webchat.server.ContactServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Api/Contact")
/**
 * 用户列表
 */

public class ContactsController {

    @Autowired
    ContactServer server;

    @GetMapping("/getThenFriend")
    public List<UserFriendVo> getThenFriend(@RequestParam int userid){

        return server.GetThenInfo(userid);
    }
}
