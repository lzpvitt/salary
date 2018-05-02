package com.sunlands.lzp.salary.controller;

import com.sunlands.lzp.salary.pojo.vo.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;

@Controller
public class LoginController {
    @RequestMapping(value = {"/","/login"})
    public String login(){

        return "login";
    }
    @RequestMapping(value = {"/addLogin"})
    public String addLogin(Manager manager,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (manager.getPassword().equals("root")) {

//            session.setAttribute("password", "not");
            String  token = Base64.getEncoder().encodeToString(manager.getPassword().getBytes());
//            System.out.println(token);
            //这里逻辑判断登录成功与否
            session.setAttribute("token",token);
            return "managerIndex";
        } else {
            return "login";
        }
    }
    @RequestMapping(value = {"/index"})
    public String index(){
        return "index";
    }


    @RequestMapping(value = {"/managerIndex"})
    public String managerIndex(){
        return "managerIndex";
    }
}
