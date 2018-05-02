package com.sunlands.lzp.salary.pojo.dto;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.vo.SalaryVO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryDTO {
    int id;
    int staff_id;
    BigDecimal base_salary;
    BigDecimal merit_pay;
    BigDecimal income;
    BigDecimal social_security;
    BigDecimal public_reserve_funds;
    BigDecimal personal_income_tax;
    BigDecimal after_tax_income;
    Date balance_date;
    Date salary_from;
    Date salary_end;

    public SalaryDTO() {
    }
public SalaryDTO(Salarys salary){
        this.id = salary.getId();
        this.staff_id =salary.getStaff_id();
        this.base_salary=salary.getBase_salary();
        this.merit_pay=salary.getMerit_pay();
        this.income = salary.getIncome();
        this.social_security=salary.getSocial_security();
        this.public_reserve_funds=salary.getPublic_reserve_funds();
        this.personal_income_tax=salary.getPersonal_income_tax();
        this.after_tax_income=salary.getAfter_tax_income();
        this.balance_date=salary.getBalance_date();
        this.salary_from=salary.getSalary_from();
        this.salary_end=salary.getSalary_end();
}
    public SalaryDTO(SalaryVO salaryVO) {
        this.id = salaryVO.getId();//id可能并没有设置  因为保存（插入）的过程中不会事先产生id
        this.staff_id = salaryVO.getStaff_id();
        this.base_salary = salaryVO.getBase_salary();
        this.merit_pay = salaryVO.getMerit_pay();
        this.income = salaryVO.getIncome();
        this.social_security = salaryVO.getSocial_security();
        this.public_reserve_funds = salaryVO.getPublic_reserve_funds();
        this.personal_income_tax = salaryVO.getPersonal_income_tax();
        this.after_tax_income = salaryVO.getAfter_tax_income();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:SS");
        try {
            this.balance_date = simpleDateFormat.parse(salaryVO.getBalance_date().replace("T"," "));
            this.salary_from = simpleDateFormat.parse(salaryVO.getSalary_from().replace("T"," "));
            this.salary_end=simpleDateFormat.parse(salaryVO.getSalary_end().replace("T"," "));
        } catch (ParseException e) {
            System.out.println("日期格式转化失败");
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public BigDecimal getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(BigDecimal base_salary) {
        this.base_salary = base_salary;
    }

    public BigDecimal getMerit_pay() {
        return merit_pay;
    }

    public void setMerit_pay(BigDecimal merit_pay) {
        this.merit_pay = merit_pay;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getSocial_security() {
        return social_security;
    }

    public void setSocial_security(BigDecimal social_security) {
        this.social_security = social_security;
    }

    public BigDecimal getPublic_reserve_funds() {
        return public_reserve_funds;
    }

    public void setPublic_reserve_funds(BigDecimal public_reserve_funds) {
        this.public_reserve_funds = public_reserve_funds;
    }

    public BigDecimal getPersonal_income_tax() {
        return personal_income_tax;
    }

    public void setPersonal_income_tax(BigDecimal personal_income_tax) {
        this.personal_income_tax = personal_income_tax;
    }

    public BigDecimal getAfter_tax_income() {
        return after_tax_income;
    }

    public void setAfter_tax_income(BigDecimal after_tax_income) {
        this.after_tax_income = after_tax_income;
    }

    public Date getBalance_date() {
        return balance_date;
    }

    public void setBalance_date(Date balance_date) {
        this.balance_date = balance_date;
    }

    public Date getSalary_from() {
        return salary_from;
    }

    public void setSalary_from(Date salary_from) {
        this.salary_from = salary_from;
    }

    public Date getSalary_end() {
        return salary_end;
    }

    public void setSalary_end(Date salary_end) {
        this.salary_end = salary_end;
    }
}
