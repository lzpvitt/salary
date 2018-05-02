package com.sunlands.lzp.salary.dao;

import com.sunlands.lzp.salary.entity.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManagerDao {
    List<Manager> selectManager(HashMap<Object, Object> params);

    int countManagers(HashMap<Object, Object> params);

    int countManager();

    void changeStatus(HashMap<Object, Object> params);

    void managerEdit(HashMap<Object, Object> params);

    void insertManager(HashMap<Object, Object> params);

    boolean deleteManager(int id);
}
