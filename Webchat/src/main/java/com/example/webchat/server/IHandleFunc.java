package com.example.webchat.server;

/**
 * 消息处理函数列表
 */
public interface IHandleFunc {
    void Login(String playLoad);


    void DispMessage(String playLoad);
}
