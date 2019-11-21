package com.recruitment.shiro;

import com.recruitment.domain.User;
import com.recruitment.mapper.LoginMapper;
import com.recruitment.utils.RedisUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;

/**
 * Author 陈琪文
 * Date 2019/11/13
 * Time 21:19
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*String username = (String) principals.getPrimaryPrincipal();
        List<SysPermission> sysPermissions = sysPermissionMapper.selectPermissionByUserName(username);
        Collection permissions = new HashSet<>();
        for (SysPermission s:sysPermissions){
            permissions.add(s.getPerName());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;*/
        return null;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken userToken) throws AuthenticationException {
        String nickname=(String)userToken.getPrincipal();
        System.out.println(nickname+"****************");
        User user=loginMapper.findByNickName(nickname);
        redisUtils.set(nickname,user,30);
        System.out.println("=====>"+user);

        SimpleAuthenticationInfo simpleAuthenticationInfo=
                new SimpleAuthenticationInfo(nickname,user.getUserPassword(),getName());

        return simpleAuthenticationInfo;
    }
}
