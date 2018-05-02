package com.sunlands.lzp.salary.pojo.dto;

public class CommonDTO {
    int pageSize=20;
    int pageNum=1;


    public CommonDTO(){}
    public CommonDTO(int pageNum ,int pageSize){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
