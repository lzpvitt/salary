package com.sunlands.lzp.salary.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Salarys {
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

    public Salarys(){}
    public Salarys(int staff_id,
                   BigDecimal base_salary,
                   BigDecimal merit_pay,
                   BigDecimal income,
                   BigDecimal social_security,
                   BigDecimal public_reserve_funds,
                   BigDecimal personal_income_tax,
                   BigDecimal after_tax_income,
                   Timestamp balance_date,
                   Timestamp salary_from,
                   Timestamp salary_end) {
        this.staff_id = staff_id;
        this.base_salary = base_salary;
        this.merit_pay = merit_pay;
        this.income = income;
        this.social_security = social_security;
        this.public_reserve_funds = public_reserve_funds;
        this.personal_income_tax = personal_income_tax;
        this.after_tax_income = after_tax_income;
        this.balance_date = balance_date;
        this.salary_end = salary_end;
        this.salary_from = salary_from;
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
