package com.sunlands.lzp.salary.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Staff {
    private int id;
    private String user_name;
    private Date birthday;
    private String email;
    private String address;
    private Date join_time;
    private BigDecimal base_salary;
    private BigDecimal merit_pay;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoin_time() {
        return join_time;
    }

    public void setJoin_time(Date join_time) {
        this.join_time = join_time;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
