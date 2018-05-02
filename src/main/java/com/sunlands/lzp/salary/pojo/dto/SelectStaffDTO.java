package com.sunlands.lzp.salary.pojo.dto;

public class SelectStaffDTO extends CommonDTO {
    private String email;
    private String user_name;
    private String join_time1;
    private String join_time2;
    private int status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getJoin_time1() {
        return join_time1;
    }

    public void setJoin_time1(String join_time1) {
        this.join_time1 = join_time1;
    }

    public String getJoin_time2() {
        return join_time2;
    }

    public void setJoin_time2(String join_time2) {
        this.join_time2 = join_time2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
