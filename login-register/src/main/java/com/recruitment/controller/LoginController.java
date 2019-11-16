package com.recruitment.controller;

import com.recruitment.domain.User;
import com.recruitment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/13 14:58
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录发送短信
    @RequestMapping("/sendphone/{userphone}")
    public String  sendphone(@PathVariable("userphone")String userphone){
        String code = loginService.sendphone(userphone);
        if("fail".equals(code)){
            return "发送失败";
        }
        return "发送成功";
    }

    //注册发送短信
    @RequestMapping("/registersendphone/{userphone}")
    public String  registersendphone(@PathVariable("userphone")String userphone){
        String registercheck = loginService.registercheck(userphone);
        if ("seccess".equals(registercheck)){
            String code = loginService.sendphone(userphone);
            if("fail".equals(code)){
                return "发送失败";
            }
            return "发送成功";
        }
       return registercheck;
    }

    //手机登录
    @RequestMapping("/phonelogin/{userphone}/{code}")
    public String  phonelogin(@PathVariable("userphone")String userphone,@PathVariable("code")String code){
        String phonelogin = loginService.phonelogin(userphone, code);
        return  phonelogin;
    }

    //密码登录
    @RequestMapping("/passlogin")
    public String  passlogin(@RequestBody User user){
        String passlogin = loginService.passlogin(user);
        return passlogin;
    }

    //手机注册
    @RequestMapping("/phoneregister/{userphone}/{code}")
    public String  phoneregister(@PathVariable("userphone")String userphone,@PathVariable("code")String code){
        String phoneregister = loginService.phoneregister(userphone, code);
        return  phoneregister;
    }
}
