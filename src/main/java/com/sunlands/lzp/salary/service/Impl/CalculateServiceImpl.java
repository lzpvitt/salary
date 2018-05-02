package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.vo.SalaryResultVO;
import com.sunlands.lzp.salary.pojo.vo.staffSalaryVO;
import com.sunlands.lzp.salary.service.CalculateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

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

    @Override
    public Salarys calculate(Rates rates, Staff staff) {
        BigDecimal hundred = new BigDecimal(100);
        Salarys salarys = new Salarys();
        salarys.setStaff_id(staff.getId());
        salarys.setBase_salary(staff.getBase_salary());
        salarys.setMerit_pay(staff.getMerit_pay());
        //收入
        salarys.setIncome(staff.getBase_salary().add(staff.getMerit_pay()));
        //社保金
        salarys.setSocial_security(salarys.getIncome().multiply(rates.getSocial_security_rate().divide(hundred)));
        //公积金
        salarys.setPublic_reserve_funds(salarys.getIncome().multiply(rates.getProvident_fund_rate().divide(hundred)));
        //个税
        salarys.setPersonal_income_tax(salarys.getIncome().subtract(rates.getBase()).multiply(rates.getIndividual_tax_ratio().divide(hundred)));
        //税后工资
        salarys.setAfter_tax_income(salarys.getIncome().subtract(salarys.getSocial_security()).subtract(salarys.getPublic_reserve_funds()).subtract(salarys.getPersonal_income_tax()));
        salarys.setBalance_date(new Date());
        salarys.setSalary_from(new Date());
        salarys.setSalary_end(new Date());
        return salarys;
    }
}
