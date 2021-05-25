package com.wqm.common.Dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AddNewMessageDto implements Serializable {
    String myUsername;
    String username;
    String message;
    LocalDateTime time;
}
