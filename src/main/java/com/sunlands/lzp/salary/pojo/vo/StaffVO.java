package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Staff;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class StaffVO {
    private int id;
    private String user_name;
    private String birthday;
    private String email;
    private String address;
    //日期格式化
    private String join_time;
    private BigDecimal base_salary;
    private BigDecimal merit_pay;
    //数字改成文字
    private String status;

    public StaffVO() {
    }

    public StaffVO(int id, String user_name, String birthday, String email, String address, String join_time, BigDecimal base_salary, BigDecimal merit_pay, String status) {
        this.id = id;
        this.user_name = user_name;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.join_time = join_time;
        this.base_salary = base_salary;
        this.merit_pay = merit_pay;
        this.status = status;
    }
    public StaffVO(String user_name, String birthday, String email, String address, String join_time, BigDecimal base_salary, BigDecimal merit_pay, String status) {
        this.user_name = user_name;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.join_time = join_time;
        this.base_salary = base_salary;
        this.merit_pay = merit_pay;
        this.status = status;
    }

    public StaffVO(Staff staff) {
        this.id = staff.getId();
        this.user_name = staff.getUser_name();
        this.email = staff.getEmail();
        this.address = staff.getAddress();
        this.base_salary = staff.getBase_salary();
        this.merit_pay = staff.getMerit_pay();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.birthday = simpleDateFormat.format(staff.getBirthday());
        this.join_time = simpleDateFormat.format(staff.getJoin_time());
        if (staff.getStatus() == 0) {
            this.status = "在职";
        } else if (staff.getStatus() == 1) {
            this.status = "请假";
        } else if (staff.getStatus() == 2) {
            this.status = "离职";
        } else {
            this.status = "状态未知";
        }
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getJoin_time() {
        return join_time;
    }

    public void setJoin_time(String join_time) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
