package com.example.webchat.Entity;

import lombok.Data;

@Data
/**
 * 描述当前用户所加好友
 */
public class UserFriendVo {

    int id;

    UserEntity userEntity;
}
