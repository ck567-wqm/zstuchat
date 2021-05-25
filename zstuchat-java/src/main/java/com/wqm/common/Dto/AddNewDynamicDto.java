package com.wqm.common.Dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AddNewDynamicDto implements Serializable {
    private Integer uid;
    private String message;

    private LocalDateTime time;
}
