package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.pojo.vo.SalaryResultVO;
import com.sunlands.lzp.salary.pojo.vo.SalaryVO;
import com.sunlands.lzp.salary.pojo.vo.staffSalaryVO;
import com.sunlands.lzp.salary.service.CalculateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public SalaryResultVO calculate(Rates rates, staffSalaryVO staffSalaryVO) {
        BigDecimal hundred = new BigDecimal(100);
        SalaryResultVO salaryResultVO = new SalaryResultVO();
        //收入
        salaryResultVO.setIncome(staffSalaryVO.getBase_salary().add(staffSalaryVO.getMerit_pay()));
        //社保金
        salaryResultVO.setSocial_security(salaryResultVO.getIncome().multiply(rates.getSocial_security_rate().divide(hundred)));
        //公积金
        salaryResultVO.setPublic_reserve_funds(salaryResultVO.getIncome().multiply(rates.getProvident_fund_rate().divide(hundred)));
        //个税
        salaryResultVO.setPersonal_income_tax(salaryResultVO.getIncome().subtract(rates.getBase()).multiply(rates.getIndividual_tax_ratio().divide(hundred)));
        //税后工资
        salaryResultVO.setAfter_tax_income(salaryResultVO.getIncome().subtract(salaryResultVO.getSocial_security()).subtract(salaryResultVO.getPublic_reserve_funds()).subtract(salaryResultVO.getPersonal_income_tax()));
        return salaryResultVO;
    }
}
