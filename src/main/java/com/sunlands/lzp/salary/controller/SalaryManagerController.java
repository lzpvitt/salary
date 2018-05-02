package com.sunlands.lzp.salary.controller;

import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.IdDTO;
import com.sunlands.lzp.salary.pojo.dto.ListEmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.TimeZoneDTO;
import com.sunlands.lzp.salary.pojo.vo.ListSalaryAndInfoVO;
import com.sunlands.lzp.salary.pojo.vo.ListSalaryVO;
import com.sunlands.lzp.salary.pojo.vo.TimeZoneVO;
import com.sunlands.lzp.salary.service.SalaryService;
import com.sunlands.lzp.salary.service.SendMailService;
import com.sunlands.lzp.salary.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SalaryManagerController {
    @Autowired
    SalaryService salaryService;
    @Autowired
    StaffService staffService;
    @Autowired
    SendMailService sendMailService;

    @RequestMapping(value = {"/selectSalaryById"})
    public ModelAndView selectSalaryById(IdDTO idDTO) {
        //根据id获取历史工资信息
        System.out.println(idDTO.getId());

        ListSalaryVO listSalaryVO = new ListSalaryVO(salaryService.selectByStaffId(idDTO));
        Staff staff = staffService.selectById(idDTO);
        ListSalaryAndInfoVO listSalaryAndInfoVO = new ListSalaryAndInfoVO(listSalaryVO,staff);
        ModelAndView modelAndView = new ModelAndView("salaryMan");
        modelAndView.addObject("listSalaryAndInfoVO",listSalaryAndInfoVO);

        return modelAndView;
    }

    @RequestMapping(value = {"/sendEmailByDate"})
    public String sendEmailByDate(TimeZoneVO timeZoneVO){
        TimeZoneDTO timeZoneDTO =new TimeZoneDTO(timeZoneVO);
        ListEmailInfoDTO listEmailInfoDTO =new ListEmailInfoDTO(salaryService.selectByTimeZone());
        sendMailService.sendMails(listEmailInfoDTO);
        return "staffEditSuccess";
    }
}
