package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.dao.ManagerDao;
import com.sunlands.lzp.salary.entity.Manager;
import com.sunlands.lzp.salary.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Override
    public List<Manager> selectManager(HashMap<Object, Object> params) {
        return managerDao.selectManager(params);
    }

    @Override
    public int countManager() {
        return managerDao.countManager();
    }

    @Override
    public int countManagers(HashMap<Object, Object> params) {
        return managerDao.countManagers(params);
    }

    @Override
    public void changeStatus(HashMap<Object, Object> params) {
        HashMap<Object, Object> checkParams = new HashMap<>();
        checkParams.put("user_name", params.get("user_name"));
        checkParams.put("id", params.get("id"));
        if (managerDao.selectManager(checkParams).size() > 0) {
            managerDao.changeStatus(params);
        } else {
            System.out.println("状态修改不成功，因为用户不存在");
        }
    }

    @Override
    public boolean managerEdit(HashMap<Object, Object> params) {
        HashMap<Object, Object> checkParams = new HashMap<>();
        checkParams.put("id", params.get("id"));
        if (managerDao.selectManager(checkParams) != null) {
            managerDao.managerEdit(params);
            return true;
        } else {
            System.out.println("资料更新失败");
            return false;
        }
    }

    @Override
    public boolean insertManager(HashMap<Object, Object> params) {
        HashMap<Object, Object> checkParams = new HashMap<>();
        if (params.get("user_name") != null) {
            checkParams.put("user_name", params.get("user_name"));
        }
        /**
         * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
         * 此方法中前三位格式有：
         * 13+任意数
         * 15+除4的任意数
         * 18+除1和4的任意数
         * 17+除9的任意数
         * 147
         */
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(params.get("tel").toString().trim());
        if (!m.matches()) {
            System.out.println("手机号不对");
            return false;
        }
        if (managerDao.selectManager(checkParams).size() == 0) {
            managerDao.insertManager(params);
            return true;
        } else {
            System.out.println("新增管理失败");
            return false;
        }
    }

    @Override
    public void deleteManager(int id) {
        HashMap<Object, Object> checkParams = new HashMap<>();
        checkParams.put("id", String.valueOf(id));
        if (managerDao.selectManager(checkParams).size() != 0) {
            managerDao.deleteManager(id);
        } else {
            System.out.println("删除失败");
        }
    }
}
