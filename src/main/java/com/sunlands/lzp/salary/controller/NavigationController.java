package com.sunlands.lzp.salary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//导航页
@Controller
public class NavigationController {

    @RequestMapping(value = {"/manInfoManager"})
    public String getManagerManager(){
        return "managerIndex";
    }

    @RequestMapping(value = {"/manInfoStaff"})
    public String getStaffManager() {
        return "staffIndex";
    }
    @RequestMapping(value = {"/manInfoSalary"})
    public String getSalaryManager(){
        return "salaryIndex";
    }

    @RequestMapping(value = {"/manInfoMail"})
    public String getMailManager(){
        return "mailIndex";
    }

}
