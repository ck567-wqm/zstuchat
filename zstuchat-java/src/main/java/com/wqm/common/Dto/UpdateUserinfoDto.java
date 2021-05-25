package com.wqm.common.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateUserinfoDto implements Serializable {

    private Integer id;

    private String signature;

    private String sex;

    private String birthday;

}
