package com.example.day1.Controller;

import com.example.day1.Service.ISendCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Login")
public class LoginController {

    /**
     * 选择SendEmailCode注入
     */
    @Qualifier("SendEmailCode")
    public ISendCode icode;

    @Autowired
    ISendCode Icode2;

    /**
     * 发送邮件的rest接口
     * @param email
     * @return
     */

    @RequestMapping(value = "/SendCode",method ={RequestMethod.GET})
    public String SendCode(@RequestParam String email){
        icode.Send(email);
        return "发送成功";
    }


}

