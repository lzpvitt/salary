package com.sunlands.lzp.salary.controller;

import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.*;
import com.sunlands.lzp.salary.pojo.vo.*;
import com.sunlands.lzp.salary.service.CalculateService;
import com.sunlands.lzp.salary.service.RatesService;
import com.sunlands.lzp.salary.service.SalaryService;
import com.sunlands.lzp.salary.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class StaffManagerController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private RatesService ratesService;
    @Autowired
    CalculateService calculateService;
    @Autowired
    SalaryService salaryService;

    @RequestMapping({"/addStaff"})
    public String addStaff() {
        return "staffAdd";
    }

    @RequestMapping(value = {"/staffMan"})
    public ModelAndView staffMan(PageDTO pageDTO) {
        ListStaffVO listStaffVO = staffService.getListStaffVO(pageDTO);
        //如果listStaffVO的code为空  应该是进入为空的逻辑
        ModelAndView mv = new ModelAndView("staffManager");
        mv.addObject("listStaffVO", listStaffVO);
        return mv;
    }

    @RequestMapping(value = {"/selectStaff"})
    public ModelAndView selectStaff(SelectStaffDTO selectStaffDTO) {
        HashMap<Object, Object> params = new HashMap<>();
        if (selectStaffDTO.getEmail() != null && !selectStaffDTO.getEmail().trim().equals("")) {
            params.put("email", selectStaffDTO.getEmail().trim());
        }
        if (selectStaffDTO.getUser_name() != null && !selectStaffDTO.getUser_name().trim().equals("")) {
            params.put("user_name", selectStaffDTO.getUser_name().trim());
        }
        if (selectStaffDTO.getStatus() > -1 && selectStaffDTO.getStatus() < 3) {
            params.put("status", selectStaffDTO.getStatus());
        }
        if (selectStaffDTO.getJoin_time1() != null && selectStaffDTO.getJoin_time2() != null) {
            params.put("join_time1", selectStaffDTO.getJoin_time1().replace("T", " "));
            params.put("join_time2", selectStaffDTO.getJoin_time2().replace("T", " "));
        }
        if (selectStaffDTO.getPageNum() != 0 && selectStaffDTO.getPageSize() != 0) {
            params.put("pageBegin", (selectStaffDTO.getPageNum() - 1) * selectStaffDTO.getPageSize());
            params.put("pageOff", selectStaffDTO.getPageSize());
        }
        List<Staff> staffList = staffService.selectStaff(params);
        Long totalNum = staffService.count(params);
        ListStaffVO listStaffVO = new ListStaffVO(staffList);
        if (selectStaffDTO.getPageNum() != 0 && selectStaffDTO.getPageSize() != 0) {
            listStaffVO.setPageNum(selectStaffDTO.getPageNum());
            listStaffVO.setPageSize(selectStaffDTO.getPageSize());
        }
        listStaffVO.setTotalNum(totalNum);
        listStaffVO.setPageNum(selectStaffDTO.getPageNum());
        System.out.println(totalNum);
        ModelAndView modelAndView = new ModelAndView("staffManager");
        modelAndView.addObject("listStaffVO", listStaffVO);
        return modelAndView;
    }

    @RequestMapping(value = {"/selectByEmail"}, method = RequestMethod.GET)
    public ModelAndView selectByEmail(EmailDTO emailDTO) {
//        System.out.println(emailDTO.getEmail());
        ListStaffVO listStaffVO = staffService.getByEmail(emailDTO);
        ModelAndView mv = new ModelAndView("staffManager");
        mv.addObject("listStaffVO", listStaffVO);
        return mv;
    }

    @RequestMapping(value = {"/selectByUserName"})
    public ModelAndView selectByUser(User_NameDTO user_nameDTO) {
        ListStaffVO listStaffVO = staffService.getByUserName(user_nameDTO);
        ModelAndView mv = new ModelAndView("staffManager");
//        System.out.println(listStaffVO.getTotalNum());
        mv.addObject("listStaffVO", listStaffVO);
        return mv;
    }

    @RequestMapping(value = {"/selectByTimeZone"})
    public ModelAndView selectByTimeZone(TimeZoneVO timeZoneVO) {
        ListStaffVO listStaffVO = staffService.getByJoin_time(new TimeZoneDTO(timeZoneVO));
        ModelAndView mv = new ModelAndView("staffManager");
        mv.addObject("listStaffVO", listStaffVO);
        return mv;
    }

    @RequestMapping(value = {"/selectByStatus"})
    public ModelAndView getStaffByStatus(StatusDTO statusDTO) {
        ListStaffVO listStaffVO = staffService.getByStatus(statusDTO);
        ModelAndView mv = new ModelAndView("staffManager");
//        System.out.println(listStaffVO.getTotalNum());
        mv.addObject("listStaffVO", listStaffVO);
        //分页信息加进去
        return mv;
    }


    @RequestMapping(value = {"/editStaff"})
    public ModelAndView getEdit(StaffVO staffVO) {
//        System.out.println(staffVO.getBirthday());
        ModelAndView modelAndView = new ModelAndView("staffedit");
        modelAndView.addObject("staffVO", staffVO);
//        return "test";
        return modelAndView;
    }

    @RequestMapping(value = {"/saveStaffEdit"})
    public String saveStaff(StaffVO staffVO) {
        //保存修改   检查有无错误数据
//        System.out.println(staffVO.getId());
//        System.out.println(staffVO.getJoin_time());
        if (staffVO.getId() >= 1) {
            staffService.updateStaff(new StaffDTO(staffVO));
        } else if (staffVO.getId() == 0) {
            System.out.println("正在保存新员工信息");
//            System.out.println(staffVO.getBirthday());
            staffService.addStaff(new StaffDTO(staffVO));
        } else {
        }
        return "staffEditSuccess";
    }


    @RequestMapping(value = {"/deleteStaffByID"})
    public String deleteStaffByID(IdDTO idDTO) {
        staffService.deleteByID(idDTO);
        //删除后应该刷新原页面的
        return "staffEditSuccess";
    }


    @RequestMapping(value = {"/addSalary"})
    public ModelAndView addSalary(staffSalaryVO staffSalaryVO) {
//        System.out.println(staffSalaryVO.getStaff_id());
        //取得基本信息  进入编辑页面
        ModelAndView modelAndView = new ModelAndView("salaryEdit");
        modelAndView.addObject("staffSalaryVO", staffSalaryVO);
        return modelAndView;
    }

    //结算工资信息
    @ResponseBody
    @RequestMapping(value = {"/calculateSalary"})
    public SalaryResultVO calculateSalary(@RequestBody staffSalaryVO staffSalaryVO) {
//        System.out.println(staffSalaryVO.getMerit_pay());
        Rates rates = ratesService.seleteRate();
//        System.out.println(rates.getBase());
        SalaryResultVO salaryResultVO = calculateService.calculate(rates, staffSalaryVO);
        return salaryResultVO;
    }

    @RequestMapping(value = {"/saveSalary"})
    public String saveSalary(SalaryVO salaryVO) {
        //因为加入了一键发工资的部分  这里改成本月已经有工资就更新 没有就加入
        salaryService.insertSalary(new SalaryDTO(salaryVO));
        return "staffEditSuccess";
    }

    @RequestMapping(value = "/calAndSendSalaryById")
    public String calAndSendSalaryById(IdDTO idDTO) {
        salaryService.sendSalary(idDTO.getId());
        return "staffEditSuccess";
    }
}
