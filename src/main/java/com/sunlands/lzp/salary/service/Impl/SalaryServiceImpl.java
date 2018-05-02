package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.dao.SalarysDao;
import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.dto.EmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.IdDTO;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;
import com.sunlands.lzp.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalarysDao salarysDao;
    @Override
    public void insertSalary(SalaryDTO salaryDTO) {
        salarysDao.insertSalarys(salaryDTO);
    }

    @Override
    public List<Salarys> selectByStaffId(IdDTO idDTO) {
        return salarysDao.selectByStaffId(idDTO);
    }

    @Override
    public List<EmailInfoDTO> selectByTimeZone() {
        return salarysDao.selectByTimeZone();
    }
}
