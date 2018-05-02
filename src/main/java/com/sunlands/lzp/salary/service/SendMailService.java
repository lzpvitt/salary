package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.entity.Salarys;
import com.sunlands.lzp.salary.entity.Staff;
import com.sunlands.lzp.salary.pojo.dto.ListEmailInfoDTO;

public interface SendMailService {
    void sendMail(String to,String subject,String cont);
    void sendMails(ListEmailInfoDTO listEmailInfoDTO);

    void sendMail(Salarys salarys, Staff staff);
}
