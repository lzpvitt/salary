package com.sunlands.lzp.salary.dao;

import com.sunlands.lzp.salary.entity.Rates;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface RatesDao {
    @Select("select * from rates where active=1 limit 1")
    Rates selectRate();
}
