package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.*;
import com.sunlands.lzp.salary.pojo.vo.ListStaffVO;

public interface StaffService {
    //增加员工
    void addStaff(StaffDTO staffDTO);

    //分页查询
    ListStaffVO getListStaffVO(PageDTO pageDTO);

    //按邮箱查询
    ListStaffVO getByEmail(EmailDTO emailDTO);

    //按姓名查找用户
    ListStaffVO getByUserName(User_NameDTO user_nameDTO);

    //根据时间段查找员工
    ListStaffVO getByJoin_time(TimeZoneDTO timeZoneDTO);

    //根据在职状态查找员工
    ListStaffVO getByStatus(StatusDTO  statusDTO);

    Staff selectById(IdDTO idDTO);

    //更新员工信息
    void updateStaff(StaffDTO staffDTO);

    void deleteByID(IdDTO idDTO);

}
