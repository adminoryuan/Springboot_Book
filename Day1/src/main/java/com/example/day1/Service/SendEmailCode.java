package com.example.day1.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *@Primary
 * 加上这个玩意表示 在注入时如果你没指定注入类 则优先选择 被 @Primary 标注的类
 */
@Primary
@Service
public class SendEmailCode implements ISendCode{
    @Override
    public void Send(String email) {
        System.out.printf("发送邮箱验证码");
    }
}
