package com.sunlands.lzp.salary.pojo.dto;

public class EmailDTO extends CommonDTO{
    private String email;

    public EmailDTO(String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
