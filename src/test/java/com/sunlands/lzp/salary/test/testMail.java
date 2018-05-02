package com.sunlands.lzp.salary.test;

import com.sunlands.lzp.salary.service.SendMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class testMail {

    @Autowired
    SendMailService sendMail;
    @Test
    public void test(){
        sendMail.sendMail("lzpvit@163.com","主题","abcdefghijklmn");
    }
}
