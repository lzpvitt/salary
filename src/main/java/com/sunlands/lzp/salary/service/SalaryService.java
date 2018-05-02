package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.dto.EmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.IdDTO;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;

import java.util.List;

public interface SalaryService {
    void insertSalary(SalaryDTO salaryDTO);

    List<Salarys> selectByStaffId(IdDTO idDTO);

    List<EmailInfoDTO> selectByTimeZone();
}
