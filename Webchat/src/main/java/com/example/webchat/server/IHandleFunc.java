package com.example.webchat.server;

/**
 * 消息处理函数列表
 */
public interface IHandleFunc {


    String Login(String playLoad);


    void DispMessage(String playLoad);
}
