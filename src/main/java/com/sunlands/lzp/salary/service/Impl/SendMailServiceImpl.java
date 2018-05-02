package com.sunlands.lzp.salary.service.Impl;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.EmailInfoDTO;
import com.sunlands.lzp.salary.pojo.dto.ListEmailInfoDTO;
import com.sunlands.lzp.salary.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    SimpleMailMessage mailMessage;
    @Override
    public void sendMail(String to, String subject, String cont) {
        mailMessage.setFrom("243510418@qq.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(cont);
        javaMailSender.send(mailMessage);
    }

    @Override
    public void sendMails(ListEmailInfoDTO listEmailInfoDTO) {
        mailMessage.setFrom("243510418@qq.com");
        Iterator iterator =listEmailInfoDTO.getEmailInfoDTOList().iterator();
        while (iterator.hasNext()){
            EmailInfoDTO emailInfoDTO = (EmailInfoDTO) iterator.next();
            mailMessage.setTo(emailInfoDTO.getEmail());
            mailMessage.setSubject("您好！".concat(emailInfoDTO.getUser_name()).concat("。这是您的工资邮件"));
            String str = "";
            str = str.concat(String.valueOf(emailInfoDTO.getBase_salary())).concat(" ");
            str.concat(String.valueOf(emailInfoDTO.getMerit_pay())).concat(" ");
            mailMessage.setText(str);
            javaMailSender.send(mailMessage);
        }
    }


    @Override
    public void sendMail(Salarys salarys, Staff staff) {
        mailMessage.setFrom("243510418@qq.com");
        String to = staff.getEmail();
        mailMessage.setTo(to);
        mailMessage.setSubject("这只是测试邮件，请忽略");
        String cont = "名字：".concat(staff.getUser_name()).concat(" 基础工资:").concat(salarys.getBase_salary().toString()).concat("绩效工资:").concat(salarys.getMerit_pay().toString());
        cont.concat("税后工资：").concat(salarys.getAfter_tax_income().toString());
        mailMessage.setText(cont);
        javaMailSender.send(mailMessage);
        System.out.println("准备发邮件。。");
    }
}
