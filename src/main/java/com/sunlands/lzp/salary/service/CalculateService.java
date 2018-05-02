package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.vo.SalaryResultVO;
import com.sunlands.lzp.salary.pojo.vo.staffSalaryVO;

public interface CalculateService {
    SalaryResultVO calculate(Rates rates,staffSalaryVO staffSalaryVO);

    Salarys calculate(Rates rates, Staff staff);
}
