package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Manager;

import java.util.HashMap;
import java.util.List;

public interface ManagerService {
    List<Manager> selectManager(HashMap<Object, Object> params);

    int countManager();

    int countManagers(HashMap<Object, Object> params);

    void changeStatus(HashMap<Object, Object> params);

    boolean managerEdit(HashMap<Object, Object> params);

    boolean insertManager(HashMap<Object, Object> params);

    void deleteManager(int id);
}
