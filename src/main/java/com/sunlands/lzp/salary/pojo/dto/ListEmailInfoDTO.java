package com.sunlands.lzp.salary.pojo.dto;

import java.util.ArrayList;
import java.util.List;

public class ListEmailInfoDTO {
    List<EmailInfoDTO> emailInfoDTOList =new ArrayList<>();

    public ListEmailInfoDTO(List<EmailInfoDTO>list){
        this.emailInfoDTOList=list;
    }
    public List<EmailInfoDTO> getEmailInfoDTOList() {
        return emailInfoDTOList;
    }

    public void setEmailInfoDTOList(List<EmailInfoDTO> emailInfoDTOList) {
        this.emailInfoDTOList = emailInfoDTOList;
    }
}
