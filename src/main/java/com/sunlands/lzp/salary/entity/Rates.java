package com.sunlands.lzp.salary.entity;

import java.math.BigDecimal;

public class Rates {
    int id;
    boolean active;
    BigDecimal individual_tax_ratio;//个税
    BigDecimal provident_fund_rate;//公积金
    BigDecimal social_security_rate;//社保
    BigDecimal base;   //纳税基础

    public Rates(){
    }
    public Rates(boolean active,BigDecimal individual_tax_ratio, BigDecimal provident_fund_rate,BigDecimal social_security_rate,BigDecimal base){
        this.active=active;
        this.individual_tax_ratio =individual_tax_ratio;
        this.provident_fund_rate = provident_fund_rate;
        this.social_security_rate =social_security_rate;
        this.base =base;
    }
    public Rates(int id,boolean active,BigDecimal individual_tax_ratio, BigDecimal provident_fund_rate,BigDecimal social_security_rate,BigDecimal base){
        this.id = id;
        this.active=active;
        this.individual_tax_ratio =individual_tax_ratio;
        this.provident_fund_rate = provident_fund_rate;
        this.social_security_rate =social_security_rate;
        this.base =base;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BigDecimal getIndividual_tax_ratio() {
        return individual_tax_ratio;
    }

    public void setIndividual_tax_ratio(BigDecimal individual_tax_ratio) {
        this.individual_tax_ratio = individual_tax_ratio;
    }

    public BigDecimal getProvident_fund_rate() {
        return provident_fund_rate;
    }

    public void setProvident_fund_rate(BigDecimal provident_fund_rate) {
        this.provident_fund_rate = provident_fund_rate;
    }

    public BigDecimal getSocial_security_rate() {
        return social_security_rate;
    }

    public void setSocial_security_rate(BigDecimal social_security_rate) {
        this.social_security_rate = social_security_rate;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }
}
