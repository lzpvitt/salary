package com.sunlands.lzp.salary.controller;

import com.sunlands.lzp.salary.pojo.vo.LoginVO;
import com.sunlands.lzp.salary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }
    @RequestMapping(value = {"/addLogin"})
    public String addLogin(LoginVO loginVO, HttpServletRequest request) {
        if (loginVO.getUsername().trim() == null || loginVO.getPassword().trim() == null) {
            return "login";
        }
        HttpSession session = request.getSession();
        HashMap<Object, Object> params = new HashMap<>();
        params.put("user_name", loginVO.getUsername().trim());
        params.put("pwd", loginVO.getPassword().trim());
        if (loginService.CheckLogin(params)) {
            String token = Base64.getEncoder().encodeToString(loginVO.getPassword().getBytes());
//            System.out.println(token);
            session.setAttribute("user_name", loginVO.getUsername());
            session.setAttribute("pwd", loginVO.getPassword());
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

    @RequestMapping(value = {"/manOut"})
    public String manOut(HttpSession session) {
        session.removeAttribute("token");
        return "login";
    }
}
