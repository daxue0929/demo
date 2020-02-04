package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class Test {

    @Autowired
    private UserService userService;

//    @GetMapping(value = "/")
//    public User test() {
//        User admin = userService.findByUsername("admin");
//
//        return admin;
//    }



    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Admin Success";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit() {
        return "Edit Success";
    }

    //注解 测试
    //用户必须拥有 delete 权限才能访问
    @RequestMapping("/delete")
    @RequiresPermissions("delete")
    @ResponseBody
    public String delete() {
        return "我是test delete方法，测试注解是否有效";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    @PostMapping("/loginuser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "redirect:index";
        } catch (Exception e) {
            return "redirect:login";
        }
    }

}
