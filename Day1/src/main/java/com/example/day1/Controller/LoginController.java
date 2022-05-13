package com.example.day1.Controller;

import com.example.day1.Service.ISendCode;
import com.example.factorystart.server.Taskfactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Login")
public class LoginController {
    @Autowired
    Taskfactory taskfactory;
    {
        System.out.printf("");
    }
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

    {
        System.out.println(icode==null);
        System.out.println(taskfactory==null);
    }
    @RequestMapping(value = "/SendCode",method ={RequestMethod.GET})
    public String SendCode(@RequestParam String email){
        Icode2.Send(email);
        taskfactory.Sumbit(new Runnable() {
            @Override
            public void run() {

            }
        });
        return "发送成功";
    }


}

