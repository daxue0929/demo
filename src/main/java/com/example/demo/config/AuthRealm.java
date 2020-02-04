package com.example.demo.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);
    @Autowired
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**
         *  User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
         *  User getAfterUser  = (User)principalCollection.getPrimaryPrincipal();
         *  两者效果一致，都是获取 user对象，
         *  两者打印结果(登录用户为 admin)：
         *   User{uid=1, username='admin', password='4b91fc877a3f4df7e812f98ebde4b5e5', roles=[Role{rid=1, rname='admin', permissions=[Permission{pid=1, name='add', url=''},
         *   Permission{pid=4, name='query', url=''}, Permission{pid=2, name='delete', url=''}, Permission{pid=3, name='edit', url=''}],
         */
        //类似 session中获取用户
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        //获取用户的角色，再获取角色拥有的所有权限
        // 登录时数据库已经把所有的东西都获取出来了
        Set<Role> roleSet = user.getRoles();
        if (CollectionUtils.isNotEmpty(roleSet)) {
            for (Role role : roleSet) {
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissions();
                if (CollectionUtils.isNotEmpty(permissionSet)) {
                    for (Permission permission : permissionSet) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //所有操作权限
        info.addStringPermissions(permissionList);//[delete, add, edit, query]
        //授权时拿到了角色
        info.addRoles(roleNameList);//[admin]

        return info;
    }

    //认证登录 (执行完将会执行 CredentialMatcher.doCredentialsMatch()方法)
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }

}
