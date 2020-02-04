package com.example.demo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroMD5Util {

    public static String MD5Pwd(String username, String pwd) {
        //可用户注册、登录 时使用
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数 加密2次
        String md5Pwd = new SimpleHash("MD5", pwd, ByteSource.Util.bytes(username + "salt"), 2).toHex();
        return md5Pwd;
    }
}
