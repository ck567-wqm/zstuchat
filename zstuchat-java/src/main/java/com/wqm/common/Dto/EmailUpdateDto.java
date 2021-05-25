package com.wqm.common.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailUpdateDto implements Serializable {
    private Integer id;

    private String email;
}
