package com.sunlands.lzp.salary.pojo.dto;

public class StatusDTO  extends CommonDTO {
    private int status;
    public StatusDTO(){}
    public StatusDTO(int status){
        this.status =status;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
