package com.sunlands.lzp.salary.pojo.vo;

public class TimeZoneVO extends CommonVO{
    private String join_time1;
    private String join_time2;

    public TimeZoneVO(){}
    public TimeZoneVO(String join_time1,String join_time2){}
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
}
