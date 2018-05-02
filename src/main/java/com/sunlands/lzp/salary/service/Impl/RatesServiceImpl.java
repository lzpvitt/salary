package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.dao.RatesDao;
import com.sunlands.lzp.salary.entity.Rates;
import com.sunlands.lzp.salary.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatesServiceImpl implements RatesService {
    @Autowired
    RatesDao ratesDao;
    @Override
    public Rates seleteRate() {
        return ratesDao.selectRate();
    }
}
