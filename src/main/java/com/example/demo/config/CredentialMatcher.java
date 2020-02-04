package com.example.demo.config;

import com.example.demo.utils.ShiroMD5Util;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialMatcher extends SimpleCredentialsMatcher {
    //密码校验规则的重写
    // AuthRealm 中 doGetAuthenticationInfo 执行之后会到达这里来 进行密码比对
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        /**
         *  获取到用户输入的密码，进行盐值加密，加密方式与注册时相同，再与数据库中已加过密的密码进行比较
         */
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        //把用户输入的密码 进行加密
        password = ShiroMD5Util.MD5Pwd(((UsernamePasswordToken) token).getUsername(),password);
        //数据库中的密码
        String dbPassword = (String) info.getCredentials();
        return this.equals(password, dbPassword);
    }
}
