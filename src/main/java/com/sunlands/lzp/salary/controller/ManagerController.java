package com.sunlands.lzp.salary.controller;

import com.sunlands.lzp.salary.entity.Manager;
import com.sunlands.lzp.salary.pojo.vo.ListManagerVO;
import com.sunlands.lzp.salary.pojo.vo.ManagerSelectVO;
import com.sunlands.lzp.salary.pojo.vo.ManagerVO;
import com.sunlands.lzp.salary.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping(value = {"/selectManager"})
    public ModelAndView selectManager(ManagerSelectVO managerSelectVO) {
        HashMap<Object, Object> params = new HashMap<>();
//        System.out.println(managerSelectVO.getUser_name());
        if (managerSelectVO.getUser_name() != null && !managerSelectVO.getUser_name().trim().equals("")) {
            params.put("user_name", managerSelectVO.getUser_name().trim());
        }
        if (managerSelectVO.getReal_name() != null && !managerSelectVO.getReal_name().trim().equals("")) {
            params.put("real_name", managerSelectVO.getReal_name().trim());
        }
        if (managerSelectVO.getTel() != null && !managerSelectVO.getTel().toString().trim().equals("")) {
            if (managerSelectVO.getTel().toString().trim().length() != 11) {
                System.out.println("手机号不对");
                //这里应该返回错误页面  而不是将参数设置为无效参数
                params.put("tel", "");
            } else {
                params.put("tel", managerSelectVO.getTel().toString().trim());
            }
        }
        if (managerSelectVO.getActive() != null && !managerSelectVO.getActive().trim().equals("")) {
            if (managerSelectVO.getActive().equals("2")) {
            } else {
                params.put("active", managerSelectVO.getActive().trim());
            }
        }
        if (managerSelectVO.getPageNum() != 0 && managerSelectVO.getPageSize() != 0) {
            params.put("pageBegin", (managerSelectVO.getPageNum() - 1) * managerSelectVO.getPageSize());
            params.put("pageOff", managerSelectVO.getPageSize());
        }
        System.out.println(managerService.countManager());
        List<Manager> managers = managerService.selectManager(params);
        ListManagerVO listManagerVO = new ListManagerVO(managers, managerService.countManagers(params));
        if (managerSelectVO.getPageNum() != 0 && managerSelectVO.getPageSize() != 0) {
            listManagerVO.setPageNum(managerSelectVO.getPageNum());
        }
        ModelAndView modelAndView = new ModelAndView("managerMan");
        modelAndView.addObject("listManagerVO", listManagerVO);
        return modelAndView;
    }

    @RequestMapping(value = {"/changeStatus"})
    public String changeStatus(ManagerVO managerVO) {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("id", String.valueOf(managerVO.getId()));
        if (managerVO.getActive().equals("活跃")) {
            params.put("active", "0");
        } else {
            params.put("active", "1");
        }
        managerService.changeStatus(params);
        return "staffEditSuccess";
    }

    @RequestMapping(value = {"/ManagerEdit"})
    public ModelAndView managerEdit(ManagerVO managerVO) {
        ModelAndView modelAndView = new ModelAndView("managerEdit");
        modelAndView.addObject("managerVO", managerVO);
        return modelAndView;
    }

    @RequestMapping(value = {"/saveManagerEdit"})
    public String saveManagerEdit(ManagerVO managerVO) {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("id", String.valueOf(managerVO.getId()));
        params.put("power", managerVO.getPower());
        params.put("user_name", managerVO.getUser_name());
        params.put("real_name", managerVO.getReal_name());
        params.put("tel", String.valueOf(managerVO.getTel()));
        params.put("active", "1");
        boolean result = managerService.managerEdit(params);
        if (result) {
            return "staffEditSuccess";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = {"/addManager"})
    public String addManager() {
        return "managerAdd";
    }

    @RequestMapping(value = {"/saveManager"})
    public String saveManager(ManagerVO managerVO) {
        System.out.println(managerVO.getPower());
        HashMap<Object, Object> params = new HashMap<>();
        params.put("user_name", managerVO.getUser_name());
        params.put("real_name", managerVO.getReal_name());
        params.put("power", String.valueOf(managerVO.getPower()));
        params.put("pwd", managerVO.getPwd());
        params.put("tel", String.valueOf(managerVO.getTel()));
        params.put("active", "1");
        boolean result = managerService.insertManager(params);
        if (result) {
            return "staffEditSuccess";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = {"/deleteManager"})
    public String deleteManager(int id) {
        managerService.deleteManager(id);
        return "staffEditSuccess";
    }
}
