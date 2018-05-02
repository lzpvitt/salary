package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.pojo.vo.SalaryResultVO;
import com.sunlands.lzp.salary.pojo.vo.staffSalaryVO;
import org.springframework.stereotype.Service;

public interface CalculateService {
    SalaryResultVO calculate(Rates rates,staffSalaryVO staffSalaryVO);
}
