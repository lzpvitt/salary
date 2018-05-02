package com.sunlands.lzp.salary.dao;

import com.sunlands.lzp.salary.entity.Manager;

import java.util.HashMap;

public interface ManagerDao {
    Manager selectByNameAndPsw(HashMap<String ,String> info);
}
