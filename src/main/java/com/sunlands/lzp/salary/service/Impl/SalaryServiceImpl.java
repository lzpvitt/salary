package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.dao.SalarysDao;
import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.EmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.IdDTO;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;
import com.sunlands.lzp.salary.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalarysDao salarysDao;
    @Autowired
    RatesService ratesService;
    @Autowired
    StaffService staffService;
    @Autowired
    CalculateService calculateService;
    @Autowired
    SendMailService sendMailService;

    @Override
    public List<Salarys> selectSalary(HashMap<Object, Object> params) {
        return salarysDao.selectSalary(params);
    }

    @Override
    public boolean sendSalary(int id) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        HashMap<Object, Object> params = new HashMap<>();
        params.put("staff_id", id);
        params.put("beginTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(cal.getTime()));
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.MILLISECOND, -1);
        params.put("endTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(cal.getTime()));
        System.out.println(params.get("beginTime"));
        System.out.println(params.get("endTime"));
        List<Salarys> salarysList = salarysDao.selectSalary(params);
        HashMap<Object, Object> getStaff = new HashMap<>();
        getStaff.put("id", id);
        if (salarysList.size() == 0) {
            //计算工资，插入，发邮件
            List<Staff> staffList = staffService.selectStaff(getStaff);
            System.out.println(getStaff.get("id"));
            if (staffList.size() != 0) {
                Staff staff = staffList.get(0);
                Rates rates = ratesService.seleteRate();
                Salarys salarys = calculateService.calculate(rates, staff);
                salarysDao.insertSalary(salarys);
                sendMailService.sendMail(salarys, staff);

            } else {
                System.out.println("用户不存在");
            }

        } else {
            //发邮件
            List<Staff> staffList = staffService.selectStaff(getStaff);
            if (staffList.size() == 0) {
                System.out.println("用户查找失败");
                return false;
            }
            if (salarysList.size() != 0) {
                Staff staff = staffList.get(0);
                Iterator iterator = salarysList.iterator();
                while (iterator.hasNext()) {
                    Salarys salarys = (Salarys) iterator.next();
                    sendMailService.sendMail(salarys, staff);
                }
            } else {
                System.out.println("工资本该存在，但查找不到");
                return false;
            }

        }
        return false;
    }

    @Override
    public void insertSalary(SalaryDTO salaryDTO) {
        HashMap<Object, Object> params = new HashMap<>();
        params.put("id", salaryDTO.getStaff_id());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        params.put("beginTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(cal.getTime()));
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.MILLISECOND, -1);
        params.put("endTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(cal.getTime()));
        System.out.println(params.get("beginTime"));
        System.out.println(params.get("endTime"));
        List<Salarys> salarysList = salarysDao.selectSalary(params);
        if (salarysList.size() == 0) {
            salarysDao.insertSalarys(salaryDTO);
        } else {
            int id = salarysList.get(0).getId();
            Salarys salarys = new Salarys();
            salarys.setId(id);
            salarys.setBase_salary(salaryDTO.getBase_salary());
            salarys.setMerit_pay(salaryDTO.getMerit_pay());
            salarys.setSalary_end(salaryDTO.getSalary_end());
            salarys.setSalary_from(salaryDTO.getSalary_from());
            salarys.setBalance_date(new Date());
            salarys.setStaff_id(salaryDTO.getStaff_id());
            salarys.setAfter_tax_income(salaryDTO.getAfter_tax_income());
            salarys.setPersonal_income_tax(salaryDTO.getPersonal_income_tax());
            salarys.setPublic_reserve_funds(salaryDTO.getPublic_reserve_funds());
            salarys.setSocial_security(salaryDTO.getSocial_security());
            salarys.setIncome(salaryDTO.getIncome());
            salarysDao.updateSalary(salarys);
            //更新完工资，补发邮件
            HashMap<Object, Object> staffParams = new HashMap<>();
            staffParams.put("id", salaryDTO.getStaff_id());
            List<Staff> staffList = staffService.selectStaff(staffParams);
            if (salarysList.size() != 0) {
                sendMailService.sendMail(salarys, staffList.get(0));
            } else {
                System.out.println("对应id没有找到员工信息");
            }

        }

    }

    @Override
    public void insertSalarys(Salarys salarys) {
        salarysDao.insertSalary(salarys);
    }

    @Override
    public List<Salarys> selectByStaffId(IdDTO idDTO) {
        return salarysDao.selectByStaffId(idDTO);
    }

    @Override
    public List<EmailInfoDTO> selectByTimeZone() {
        return salarysDao.selectByTimeZone();
    }
}
