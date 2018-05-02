package com.sunlands.lzp.salary.service.Impl;

import com.github.pagehelper.PageHelper;
import com.sunlands.lzp.salary.dao.StaffDao;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.*;
import com.sunlands.lzp.salary.pojo.vo.ListStaffVO;
import com.sunlands.lzp.salary.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDao staffDao;

    @Override
    public List<Staff> selectStaff(HashMap<Object, Object> params) {
        return staffDao.selectList(params);
    }

    @Override
    public Long count(HashMap<Object, Object> params) {
        return staffDao.count(params);
    }

    @Override
    public void addStaff(StaffDTO staffDTO) {
        staffDao.addStaff(staffDTO);
    }

    @Override
    public ListStaffVO getListStaffVO(PageDTO pageDTO) {
        return new ListStaffVO(staffDao.selectAllStaff(pageDTO),staffDao.countStaff());
    }

    @Override
    public ListStaffVO getByEmail(EmailDTO emailDTO) {
        if(emailDTO.getPageNum()!=0&&emailDTO.getPageSize()!=0){
            PageHelper.startPage(emailDTO.getPageNum(),emailDTO.getPageSize());
        }else {
            PageHelper.startPage(1, 20);
        }
        ListStaffVO listStaffVO= new ListStaffVO(staffDao.selectByEmail(emailDTO),staffDao.countByEmail(emailDTO));
        listStaffVO.setPageNum(emailDTO.getPageNum());
        listStaffVO.setPageSize(emailDTO.getPageSize());
        return listStaffVO;
    }

    @Override
    public ListStaffVO getByUserName(User_NameDTO user_nameDTO) {
        if(user_nameDTO.getPageNum()!=0&&user_nameDTO.getPageSize()!=0){
            PageHelper.startPage(user_nameDTO.getPageNum(),user_nameDTO.getPageSize());
        }else {
            PageHelper.startPage(1,20);
        }
        //这里调用staff.countStaff计算出来的是总的staff数目
        //按照不同的元素筛选  count函数应该不同的
        ListStaffVO listStaffVO= new ListStaffVO(staffDao.selectByUserName(user_nameDTO),staffDao.countByName(user_nameDTO));
        listStaffVO.setPageNum(user_nameDTO.getPageNum());
        listStaffVO.setPageSize(user_nameDTO.getPageSize());
        return listStaffVO;
    }

    @Override
    public ListStaffVO getByJoin_time(TimeZoneDTO timeZoneDTO) {
        if(timeZoneDTO.getPageNum()!=0&&timeZoneDTO.getPageSize()!=0){
            PageHelper.startPage(timeZoneDTO.getPageNum(),timeZoneDTO.getPageSize());
        }else {
            PageHelper.startPage(1,20);
        }
        ListStaffVO listStaffVO = new ListStaffVO(staffDao.selectByJoinTime(timeZoneDTO),staffDao.countByJoinTime(timeZoneDTO));
        listStaffVO.setPageNum(timeZoneDTO.getPageNum());
        listStaffVO.setPageSize(timeZoneDTO.getPageSize());
        return  listStaffVO;
    }

    @Override
    public ListStaffVO getByStatus(StatusDTO statusDTO) {
        if(statusDTO.getPageNum()!=0&&statusDTO.getPageSize()!=0){
            PageHelper.startPage(statusDTO.getPageNum(),statusDTO.getPageSize());
        }else {
            PageHelper.startPage(1,20);
        }
        //这里的count函数应该修改为根据status的条件的数目
        ListStaffVO listStaffVO= new ListStaffVO(staffDao.selectByStatus(statusDTO),staffDao.countByStatus(statusDTO));
        listStaffVO.setPageNum(statusDTO.getPageNum());
        listStaffVO.setPageSize(statusDTO.getPageSize());
        return listStaffVO;
    }

    @Override
    public void updateStaff(StaffDTO staffDTO) {
        staffDao.updateStaff(staffDTO);
    }

    @Override
    public void deleteByID(IdDTO idDTO) {
        staffDao.deleteByID(idDTO);
    }

    @Override
    public Staff selectById(IdDTO idDTO) {
        return staffDao.selectById(idDTO);
    }
}
