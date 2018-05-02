package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class SalaryVO {
    int id;
    int staff_id;
    BigDecimal base_salary;
    BigDecimal merit_pay;
    BigDecimal income;
    BigDecimal social_security;
    BigDecimal public_reserve_funds;
    BigDecimal personal_income_tax;
    BigDecimal after_tax_income;
    String balance_date;
    String salary_from;
    String salary_end;

    public SalaryVO(){}
    //前端往后传  往往不需要传id  因为是存储salary信息
    public SalaryVO(int staff_id,
            BigDecimal base_salary,
            BigDecimal merit_pay,
            BigDecimal income,
            BigDecimal social_security,
            BigDecimal public_reserve_funds,
            BigDecimal personal_income_tax,
            BigDecimal after_tax_income,
            String balance_date,
            String salary_from,
            String salary_end){
        this.staff_id=staff_id;
        this.base_salary=base_salary;
        this.merit_pay=merit_pay;
        this.income=income;
        this.social_security=social_security;
        this.public_reserve_funds=public_reserve_funds;
        this.personal_income_tax=personal_income_tax;
        this.after_tax_income=after_tax_income;
        this.balance_date=balance_date;
        this.salary_from=salary_from;
        this.salary_end=salary_end;
    }

    //后端往前端传  往往需要传id  因为工资信息可能需要修改
    public SalaryVO(SalaryDTO salaryDTO){
        this.id = salaryDTO.getId();
        this.staff_id=salaryDTO.getStaff_id();
        this.base_salary=salaryDTO.getBase_salary();
        this.merit_pay=salaryDTO.getMerit_pay();
        this.income=salaryDTO.getIncome();
        this.social_security=salaryDTO.getSocial_security();
        this.public_reserve_funds=salaryDTO.getPublic_reserve_funds();
        this.personal_income_tax=salaryDTO.getPersonal_income_tax();
        this.after_tax_income=salaryDTO.getAfter_tax_income();
        //日期格式转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:SS");
        this.balance_date=simpleDateFormat.format(salaryDTO.getBalance_date());
        this.salary_from=simpleDateFormat.format(salaryDTO.getSalary_from());
        this.salary_end=simpleDateFormat.format(salaryDTO.getSalary_end());
    }
    public SalaryVO(Salarys salarys){
        this.id = salarys.getId();
        this.staff_id=salarys.getStaff_id();
        this.base_salary=salarys.getBase_salary();
        this.merit_pay=salarys.getMerit_pay();
        this.income=salarys.getIncome();
        this.social_security=salarys.getSocial_security();
        this.public_reserve_funds=salarys.getPublic_reserve_funds();
        this.personal_income_tax=salarys.getPersonal_income_tax();
        this.after_tax_income=salarys.getAfter_tax_income();
        //日期格式转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:SS");
        this.balance_date=simpleDateFormat.format(salarys.getBalance_date());
        this.salary_from=simpleDateFormat.format(salarys.getSalary_from());
        this.salary_end=simpleDateFormat.format(salarys.getSalary_end());
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

    public String getBalance_date() {
        return balance_date;
    }

    public void setBalance_date(String balance_date) {
        this.balance_date = balance_date;
    }

    public String getSalary_from() {
        return salary_from;
    }

    public void setSalary_from(String salary_from) {
        this.salary_from = salary_from;
    }

    public String getSalary_end() {
        return salary_end;
    }

    public void setSalary_end(String salary_end) {
        this.salary_end = salary_end;
    }
}
