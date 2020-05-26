package com.example.springbootshiroproject.config;

import com.example.springbootshiroproject.pojo.User;
import com.example.springbootshiroproject.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther Carroll
 * @Date 2020/5/25
 * @e-mail ggq_carroll@163.com
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权：doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermission("user:add");
        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();

        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getPerms());
        System.out.println(info);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证：doGetAuthenticationInfo");

        //用户名  密码   数据库中取数据
       /* String name = "root";
        String password = "123456";*/



        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.queryUserByName(userToken.getUsername());
        if(user==null){
            return null;
        }

        //密码认证   shiro  做

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
