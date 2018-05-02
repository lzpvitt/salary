package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Staff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStaffVO extends CommonVO {
    private long totalNum;
    private List<StaffVO> StaffVOS = new ArrayList<StaffVO>();
    public ListStaffVO(List<Staff> staffs,long totalNum){
        //应该加上返回数目为空的情况
        //将list的staff转成staffvo
        Iterator iterator = staffs.iterator();
        while (iterator.hasNext()){
            StaffVO StaffVO =new StaffVO((Staff) iterator.next());
//            System.out.println(StaffVO.getAddress());
            this.StaffVOS.add(StaffVO);
        }
        this.totalNum =totalNum;

    }

    public ListStaffVO(List<Staff> staffs){
        //将list的staff转成staffvo
        Iterator iterator = staffs.iterator();
        int i =0;
        while (iterator.hasNext()){
            StaffVO StaffVO =new StaffVO((Staff) iterator.next());
            i++;
            System.out.println(StaffVO.getAddress());
            this.StaffVOS.add(StaffVO);
        }
        this.totalNum = i;
    }

    public List<StaffVO> getStaffVOS() {
        return StaffVOS;
    }

    public void setStaffVOS(List<StaffVO> StaffVOS) {
        this.StaffVOS = StaffVOS;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }
}
