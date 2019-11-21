package com.recruitment.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.recruitment.domain.User;
import com.recruitment.mapper.LoginMapper;
import com.recruitment.service.LoginService;
import com.recruitment.utils.TelUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/13 15:00
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TelUtils telUtils;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    //发送短信
    @Override
    public String sendphone(String userphone) {
        String code="";
        try {
            code = telUtils.telUtil(userphone);
            if("fail".equals(code)){
                return code;
            }
            redisTemplate.opsForValue().set(userphone,code,5,TimeUnit.MINUTES);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }

    //手机注册
    @Override
    public String  phoneregister(String userphone, String code) {
        System.out.println((String )redisTemplate.opsForValue().get(userphone));
        String  code1= redisTemplate.opsForValue().get(userphone).toString();
        System.out.println("=====================");
        if(code.equals(code1)){
            User u =new User();
            u.setUserPhone(userphone);
            loginMapper.save(u);
            return "seccess";
        }
        return "fail";
    }

    //判断账户是否存在
    @Override
    public String registercheck(String userphone) {
        User byUserPhone = loginMapper.findByUserPhone(userphone);
        System.out.println(byUserPhone+"++++++++++++++++");
        if(byUserPhone!=null){
            return "账号已存在";
        }
        return "seccess";
    }

    @Override
    public User getUserByUserPhone(String userPhone) {
        User byUserPhone = loginMapper.findByUserPhone(userPhone);
        return byUserPhone;
    }

    //手机登录
    @Override
    public String  phonelogin(String userphone, String code) {
        /*System.out.println((String )redisTemplate.opsForValue().get(userphone));*/
        User byUserPhone = loginMapper.findByUserPhone(userphone);
        if(byUserPhone==null){
            return "此账号不存在，请先注册";
        }else {
            String  code1= redisTemplate.opsForValue().get(userphone).toString();
            if(code.equals(code1)){
                return "seccess";
            }
            return "fail";
        }
    }

    //账户登录
    @Override
    public String passlogin(User user) {
        String nickname = user.getNickName();
        String userPassword = user.getUserPassword();
        /*loginMapper.findByNickname(nickname);*/
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(nickname, userPassword);
        System.out.println("//////////////////");
        try {
            subject.login(usernamePasswordToken);
            System.out.println("////////////////////+");
            if (subject.isAuthenticated()){
                System.out.println("登录成功");
               /* redisTemplate.opsForValue().set(nickname,"success",30,TimeUnit.MINUTES);*/
                return "success";
            }else {
                System.out.println("登录失败");
                return "fail";
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println("登录失败");
        return "fail";
    }
}
