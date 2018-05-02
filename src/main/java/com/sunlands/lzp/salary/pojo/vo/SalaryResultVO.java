package com.sunlands.lzp.salary.pojo.vo;

import java.math.BigDecimal;

public class SalaryResultVO {
    BigDecimal income;//前端   后端负责计算  异步请求
    BigDecimal social_security;
    BigDecimal public_reserve_funds;
    BigDecimal personal_income_tax;
    BigDecimal after_tax_income;

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
}
