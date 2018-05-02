package com.sunlands.lzp.salary.pojo.dto;

public class User_NameDTO extends CommonDTO{
    private String user_name;

    public User_NameDTO(){}
    public User_NameDTO(String user_name){
        this.user_name = user_name;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
