package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSalaryVO  extends CommonVO{
    List<SalaryVO> salaryVOList =new ArrayList<>();
    private long total;
    public ListSalaryVO(List<SalaryDTO> salaryDTOList,long total){
        Iterator iterator = salaryDTOList.iterator();
        int i= salaryDTOList.size();
        if(i!=0)this.total =total;
        SalaryDTO salaryDTO =null;
        while(iterator.hasNext()){
            salaryDTO =(SalaryDTO) iterator.next();
            this.salaryVOList.add(new SalaryVO(salaryDTO));
        }
    }
    public ListSalaryVO(List<Salarys> salarysList){
        Iterator iterator = salarysList.iterator();
        int i= salarysList.size();
        if(i!=0)this.total =i;
        Salarys salarys =null;
        while(iterator.hasNext()){
             salarys =(Salarys) iterator.next();
            this.salaryVOList.add(new SalaryVO(salarys));
        }
    }

    public List<SalaryVO> getSalaryVOList() {
        return salaryVOList;
    }

    public void setSalaryVOList(List<SalaryVO> salaryVOList) {
        this.salaryVOList = salaryVOList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
