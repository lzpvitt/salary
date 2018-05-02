package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.dto.EmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.IdDTO;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;

import java.util.HashMap;
import java.util.List;

public interface SalaryService {

    List<Salarys> selectSalary(HashMap<Object, Object> params);

    boolean sendSalary(int id);

    void insertSalary(SalaryDTO salaryDTO);

    void insertSalarys(Salarys salarys);
    List<Salarys> selectByStaffId(IdDTO idDTO);

    List<EmailInfoDTO> selectByTimeZone();
}
