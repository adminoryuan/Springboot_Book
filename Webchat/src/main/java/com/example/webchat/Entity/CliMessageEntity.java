package com.example.webchat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 规定一下消息的格式
 */
@Data
@AllArgsConstructor
public class CliMessageEntity<T>{

    /**
     * 消息类型
     */
    int MegType;

    /**
     * 请求访问令牌
     */
    String Token;


    T PlayLoad;


}
