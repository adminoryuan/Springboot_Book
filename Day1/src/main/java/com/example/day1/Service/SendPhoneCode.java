package com.example.day1.Service;

import org.springframework.stereotype.Service;

@Service
public class SendPhoneCode implements ISendCode{
    @Override
    public void Send(String email) {
        System.out.printf("发送手机验证码");
    }
}
