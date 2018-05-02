package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Staff;

public class ListSalaryAndInfoVO {
   private ListSalaryVO listSalaryVO;
   private Staff staff;

   public ListSalaryAndInfoVO(ListSalaryVO listSalaryVO,Staff staff){
       this.listSalaryVO=listSalaryVO;
       this.staff=staff;
   }
    public ListSalaryVO getListSalaryVO() {
        return listSalaryVO;
    }

    public void setListSalaryVO(ListSalaryVO listSalaryVO) {
        this.listSalaryVO = listSalaryVO;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
