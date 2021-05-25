package com.wqm.common.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class pwdUpdateDto implements Serializable {
    private Integer id;

    private String password;

    private String newPassWord;

}
