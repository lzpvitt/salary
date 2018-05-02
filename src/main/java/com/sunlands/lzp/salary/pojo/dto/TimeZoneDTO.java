package com.sunlands.lzp.salary.pojo.dto;

import com.sunlands.lzp.salary.pojo.vo.TimeZoneVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeZoneDTO extends CommonDTO{
    private Date join_time1;
    private Date join_time2;

    public TimeZoneDTO(){}
    public TimeZoneDTO(TimeZoneVO timeZoneVO){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:SS");
        try {
            this.join_time1 = simpleDateFormat.parse(timeZoneVO.getJoin_time1().replace("T"," "));
            this.join_time2 = simpleDateFormat.parse(timeZoneVO.getJoin_time2().replace("T"," "));
        } catch (ParseException e) {
            System.out.println("时间区间转化失败");
            e.printStackTrace();
        }
        this.pageNum=timeZoneVO.getPageNum();
        this.pageSize=timeZoneVO.getPageSize();

    }
    public Date getJoin_time1() {
        return join_time1;
    }

    public void setJoin_time1(Date join_time1) {
        this.join_time1 = join_time1;
    }

    public Date getJoin_time2() {
        return join_time2;
    }

    public void setJoin_time2(Date join_time2) {
        this.join_time2 = join_time2;
    }
}
