package com.example.webchat.Entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("chat_User")
public class UserEntity {
    int Id;
    Integer Age;


    String Name;

    String password;

    String Email;

    int Sex;

    /**
     * 头像
     */

    Byte[] img;
}
