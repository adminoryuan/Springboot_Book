package com.example.webchat.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 规定一下消息的格式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CliMessageEntity{

    /**
     * 消息类型
     */
    int MegType;

    /**
     * 请求访问令牌
     */
    String Token;


    String PlayLoad;


}
