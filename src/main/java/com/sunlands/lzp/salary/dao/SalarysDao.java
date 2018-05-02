package com.sunlands.lzp.salary.dao;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.pojo.dto.EmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.IdDTO;
import com.sunlands.lzp.salary.pojo.dto.SalaryDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalarysDao {
@Insert("insert into salarys set staff_id=#{staff_id},base_salary=#{base_salary},merit_pay=#{merit_pay},income=#{income},social_security=#{social_security},public_reserve_funds=#{public_reserve_funds},personal_income_tax=#{personal_income_tax},after_tax_income=#{after_tax_income},balance_date=#{balance_date},salary_from=#{salary_from},salary_end=#{salary_end}")
    void insertSalarys(SalaryDTO salaryDTO);

@Select("select * from salarys where staff_id = #{id}")
    List<Salarys> selectByStaffId(IdDTO idDTO);

@Select("select user_name,email ,s.* from staff st,salarys s where st.id=s.staff_id")
    List<EmailInfoDTO> selectByTimeZone();
}
