package com.sunlands.lzp.salary.pojo.vo;

import java.math.BigDecimal;

public class staffSalaryVO {
    private int staff_id;
    private BigDecimal base_salary;
    private BigDecimal merit_pay;
    private String user_name;

    public staffSalaryVO(){}
    public staffSalaryVO(int staff_id, BigDecimal base_salary, BigDecimal merit_pay,String user_name){
        this.staff_id = staff_id;
        this.base_salary = base_salary;
        this.merit_pay = merit_pay;
        this.user_name =user_name;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
