package com.recruitment.controller;

import com.recruitment.domain.User;
import com.recruitment.service.LoginService;
import com.recruitment.utils.CookieUtils;
import com.recruitment.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/13 14:58
 */
@RestController
public class LoginController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CookieUtils cookieUtils;

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
    //手机注册
    @RequestMapping("/registerphone/{userphone}/{phonecode}")
    public String  registerphone(@PathVariable("userphone")String userphone,@PathVariable("phonecode")String phonecode,HttpServletRequest req, HttpServletResponse resp){
        String phoneregister = loginService.phoneregister(userphone, phonecode);
        if ("success".equals(phoneregister)) {
            String token = UUID.randomUUID().toString();
            redisUtils.set("p2ptoken" + token, userphone, 300);
            return token;
        }
        return  phoneregister;
    }

    //手机登录
    @RequestMapping("/phonelogin/{userphone}/{phonecode}")
    public String  phonelogin(@PathVariable("userphone")String userphone,@PathVariable("phonecode")String phonecode,HttpServletRequest req, HttpServletResponse resp){
        String phonelogin = loginService.phonelogin(userphone, phonecode);
        if ("success".equals(phonelogin)) {
            String token = UUID.randomUUID().toString();
            redisUtils.set("p2ptoken" + token, userphone, 300);
            return token;
        }
        return  phonelogin;
    }

    /*//密码登录
    @RequestMapping("/passlogin")
    public String  passlogin(@RequestBody User user){
        String passlogin = loginService.passlogin(user);
        return passlogin;
    }*/
    //密码登录
    @RequestMapping("/passlogin")
    public String  passlogin(@RequestBody User user,HttpServletRequest req, HttpServletResponse resp){
        String passlogin = loginService.passlogin(user);
        if ("success".equals(passlogin)) {
            String token = UUID.randomUUID().toString();
            Map<String, String> map = (Map<String, String>) redisUtils.get(user.getNickName());
            redisUtils.set("p2ptoken" + token, map.get("userPhone"), 300);
            return token;
        } else {
            return passlogin;
        }
    }

    //退出登录
    @RequestMapping("/passlogin/{token}")
    public void  logout(@PathVariable("token")String token, HttpServletRequest req, HttpServletResponse resp){
        redisUtils.set("p2ptoken" + token, 0);
    }
}
