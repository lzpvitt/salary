package com.sunlands.lzp.salary.dao;

import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StaffDao {


    List<Staff> selectList(Map<Object, Object> cond);

    Long count(Map<Object, Object> cond);


    //增加员工
    @Insert("insert into staff (user_name,birthday,email,address,join_time,base_salary,merit_pay,status) values(#{user_name},#{birthday},#{email},#{address},#{join_time},#{base_salary},#{merit_pay},#{status})")
    void addStaff(StaffDTO staffDTO);

    //分页查询   没有测试
    @Select("select * from staff where id<#{pageNum} and status<3")
    List<Staff> selectAllStaff(PageDTO pageDTO);

    //查询总员工数
    @Select("select count(id) from staff where status<3")
    int countStaff();

    //按照姓名计算总数
    @Select("select count(id) from staff where user_name=#{user_name} and status<3")
    int countByName(User_NameDTO user_nameDTO);
    //按照姓名查找员工
    @Select("select * from staff where user_name=#{user_name} and status<3")
    List<Staff> selectByUserName(User_NameDTO user_nameDTO);


    @Select("select count(id) from staff where email=#{email} and status<3")
    int countByEmail(EmailDTO emailDTO);
    //根据邮箱查员工
    @Select("select * from staff where email=#{emailDTO.email} and status<3")
    List<Staff> selectByEmail(@Param("emailDTO") EmailDTO emailDTO);

    //根据时间计算总数
    @Select("select count(id) from staff where join_time>#{join_time1} and join_time<#{join_time2} and status<3")
    int countByJoinTime(TimeZoneDTO timeZoneDTO);
    //根据加入  时间段查员工
    @Select("select * from staff where join_time>#{join_time1} and join_time<#{join_time2} and status<3")
    List<Staff> selectByJoinTime(TimeZoneDTO timeZoneDTO);

    //根据员工在职状态计算总数
    @Select("select count(id) from staff where status=#{status}")
    int countByStatus(StatusDTO statusDTO);
    //根据在职状态查员工
    @Select("select * from staff where status=#{status}")
    List<Staff> selectByStatus(StatusDTO statusDTO);

    //根据id查找某一个员工
    @Select("select * from staff where id= #{id} limit 1")
    Staff selectById(IdDTO idDTO);

    @Update("update staff set user_name=#{staffDTO.user_name},birthday=#{staffDTO.birthday},email=#{staffDTO.email},address=#{staffDTO.address},join_time=#{staffDTO.join_time},base_salary=#{staffDTO.base_salary},merit_pay=#{staffDTO.merit_pay},status=#{staffDTO.status} where id= #{staffDTO.id}")
    void updateStaff(@Param("staffDTO")StaffDTO staffDTO);


    //不能采取硬删除的方式
//    @Delete("delete from staff where id = #{id}")
//    void deleteByID(IdDTO idDTO);
    @Update("update staff set status=3 where id= #{id}")
    void deleteByID(IdDTO idDTO);


}
