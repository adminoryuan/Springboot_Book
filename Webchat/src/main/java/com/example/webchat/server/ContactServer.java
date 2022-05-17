package com.example.webchat.server;

import com.example.webchat.Entity.UserEntity;
import com.example.webchat.Entity.UserFriendVo;
import com.example.webchat.Mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class ContactServer {

    @Autowired
    FriendsMapper mapper;


    /**
     * 获取个人详细信息
     * @return
     */
    public List<UserFriendVo> GetThenInfo(int usseId){
        return mapper.GetAllFriend(usseId);
    }


}
