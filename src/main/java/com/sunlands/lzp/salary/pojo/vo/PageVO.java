package com.sunlands.lzp.salary.pojo.vo;

public class PageVO {
    private int pageNum = 1;
    private String url;

    public PageVO(){}
    public PageVO(int pageNum, String url){
        this.pageNum =pageNum;
        this.url= url;
    }
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
