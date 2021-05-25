package com.wqm.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MyMessageVo implements Serializable {
    String username;
    String avatar;
    String message;
    LocalDateTime time;
}
