package com.sunlands.lzp.salary.controller;

import com.sunlands.lzp.salary.config.ConfDataSource;
import com.sunlands.lzp.salary.dao.StaffDao;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.StaffDTO;
import com.sunlands.lzp.salary.pojo.vo.ListStaffVO;
import com.sunlands.lzp.salary.pojo.vo.StaffVO;
import com.sunlands.lzp.salary.service.StaffService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;


@Controller
public class testsController {
    @Autowired
    ConfDataSource dataSource;
    @Autowired
    StaffService staffService;

    @RequestMapping(value = {"/testD"})
    public String test() {
//        ListStaffVO listStaffVO =staffService.getListStaffVO();
//        System.out.println(listStaffVO.getTotalNum());
        return "test";
    }

    @RequestMapping(value = {"/index1"})
    public String getindex1() {
        return "index1";
    }

    @RequestMapping(value = {"/staffManager"})
    public String staffManager() {
        return "staffManager";
    }

    @RequestMapping(value = {"/staffIndex"})
    public String staffIndex() {
        return "staffIndex";
    }

    @RequestMapping(value = {"/addStaffs"})
    public void add() {
        int i=400;
        while (i<600) {
            StaffVO staffVO = new StaffVO();
            staffVO.setUser_name("lzp");
//            staffVO.setUser_name("lzp".concat(String.valueOf(i)));
            staffVO.setAddress("湖北");
            staffVO.setBirthday("2010-12-03 05:08:26");
//            staffVO.setEmail(String.valueOf(i).concat("0000").concat("@qq.com"));
            staffVO.setEmail("2574533926@qq.com");
            staffVO.setJoin_time("2016-12-06 23:25:36");
            staffVO.setBase_salary(new BigDecimal(54565));
            staffVO.setMerit_pay(new BigDecimal(8989));
            staffVO.setStatus("在职");
            staffService.addStaff(new StaffDTO(staffVO));
            i++;
        }
    }
}
