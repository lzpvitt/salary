package com.sunlands.lzp.salary.pojo.dto;

import com.sunlands.lzp.salary.pojo.vo.StaffVO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaffDTO {
    private int id;
    private String user_name;
    private Date birthday;
    private String email;
    private String address;
    private Date join_time;
    private BigDecimal base_salary;
    private BigDecimal merit_pay;
    private int status;

    public StaffDTO(StaffVO staffVO){
        this.id = staffVO.getId();
        this.address=staffVO.getAddress().trim().replace(" ","");
        this.user_name=staffVO.getUser_name();
        this.email=staffVO.getEmail();
        this.base_salary=staffVO.getBase_salary();
        this.merit_pay=staffVO.getMerit_pay();
        switch (staffVO.getStatus()){
            case "在职":
                this.status = 0;
                break;
            case "请假":
                this.status = 1;
                break;
            case "离职":
                this.status = 2;
                break;
            case "状态未知":
                this.status = 3;
                break;
            default:
                this.status = 3;
        }

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //若前端date-local 传过来的时间格式为2018-04-27T12:05:09   去掉中间的T
            this.birthday = simpleDateFormat.parse(staffVO.getBirthday().replace("T"," "));
            this.join_time= simpleDateFormat.parse(staffVO.getJoin_time().replace("T"," "));
        } catch (ParseException e) {
            System.out.println("字符串格式转时间失败");
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoin_time() {
        return join_time;
    }

    public void setJoin_time(Date join_time) {
        this.join_time = join_time;
    }

    public BigDecimal getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(BigDecimal base_salary) {
        this.base_salary = base_salary;
    }

    public BigDecimal getMerit_pay() {
        return merit_pay;
    }

    public void setMerit_pay(BigDecimal merit_pay) {
        this.merit_pay = merit_pay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
