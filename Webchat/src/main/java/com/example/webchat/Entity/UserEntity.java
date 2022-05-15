package com.example.webchat.Entity;


import lombok.Data;

@Data
public class UserEntity {
    int Id;
    Integer Age;
    String admin;
    String password;
    String Email;
    String Sex;

    /**
     * 头像
     */
    Byte[] UserImg;
}
