package com.sunlands.lzp.salary.pojo.dto;

public class PageDTO {
    private int eachNum=20;
    private int pageNum;

    public int getEachNum() {
        return eachNum;
    }

    public void setEachNum(int eachNum) {
        this.eachNum = eachNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
