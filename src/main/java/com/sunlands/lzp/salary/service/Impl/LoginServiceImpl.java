package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.entity.Manager;
import com.sunlands.lzp.salary.service.LoginService;
import com.sunlands.lzp.salary.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    ManagerService managerService;

    @Override
    public boolean CheckLogin(HashMap<Object, Object> info) {
        List<Manager> managerList = managerService.selectManager(info);
        System.out.println(info.get("user_name"));
        System.out.println(info.get("pwd"));
        if (managerList.size() != 0) {
            if (managerList.get(0).isActive()) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("冻结状态");
                return false;
            }

        }
        return false;
    }
}
