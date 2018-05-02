package com.sunlands.lzp.salary.pojo.vo;

import com.sunlands.lzp.salary.entity.Manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListManagerVO extends CommonVO {
    private int totalNum = 0;
    List<ManagerVO> list = new ArrayList<>();

    public ListManagerVO(List<Manager> managers) {
        Iterator iterator = managers.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            list.add(new ManagerVO((Manager) iterator.next()));
        }
        this.totalNum = i;
    }

    public ListManagerVO(List<Manager> managers, int totalNum) {
        Iterator iterator = managers.iterator();
        while (iterator.hasNext()) {
            list.add(new ManagerVO((Manager) iterator.next()));
        }
        this.totalNum = totalNum;
    }

    public List<ManagerVO> getList() {
        return list;
    }

    public void setList(List<ManagerVO> list) {
        this.list = list;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
