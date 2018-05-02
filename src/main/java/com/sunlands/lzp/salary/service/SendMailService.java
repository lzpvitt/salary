package com.sunlands.lzp.salary.service;

import com.sunlands.lzp.salary.pojo.dto.ListEmailInfoDTO;

public interface SendMailService {
    void sendMail(String to,String subject,String cont);
    void sendMails(ListEmailInfoDTO listEmailInfoDTO);
}
