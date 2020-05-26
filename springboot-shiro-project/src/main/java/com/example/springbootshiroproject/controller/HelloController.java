package com.example.springbootshiroproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * @Auther Carroll
 * @Date 2020/5/25
 * @e-mail ggq_carroll@163.com
 */
@Controller
@Api(value ="",description  = "用户控制层")
public class HelloController {

    @ApiOperation("跳转首页方法")
    @GetMapping("/index")
    public String toIndex(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }

    @ApiOperation("跳转add方法")
    @PostMapping("/user/add")
    public String add(){
        return "/user/add";
    }

    @ApiOperation("跳转update方法")
    @PostMapping("/user/update")
    public String update(){
        return "/user/update";
    }

    @ApiOperation("跳转登录页面方法")
    @GetMapping("/tologin")
    public String login(){
        return "login";
    }

    @ApiOperation(value = "登录方法")
    @PostMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);//执行登录的方法
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @ApiOperation(value = "跳转未授权页面方法")
    @GetMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权，不能访问此页面";
    }
}
