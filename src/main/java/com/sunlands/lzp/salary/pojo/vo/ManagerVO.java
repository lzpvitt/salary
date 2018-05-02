package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Manager;

public class ManagerVO {
    private int id;
    private String power;
    private String user_name;
    private String real_name;
    private String pwd;
    private long tel;
    private String active;

    public ManagerVO() {
    }

    public ManagerVO(Manager manager) {
        this.id = manager.getId();
        if (manager.getPower() == 0) {
            this.power = "超级管理";
        } else {
            this.power = "普通管理";
        }
        this.user_name = manager.getUser_name();
        this.real_name = manager.getReal_name();
        this.pwd = manager.getPwd();
        this.tel = manager.getTel();
        if (manager.isActive() == true) {
            this.active = "活跃";
        } else {
            this.active = "冻结";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
