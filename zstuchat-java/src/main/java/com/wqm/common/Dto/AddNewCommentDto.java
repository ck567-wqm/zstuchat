package com.wqm.common.Dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AddNewCommentDto implements Serializable {
    Integer uid;
    String comment;
    LocalDateTime time;
    Integer mid;
    Integer reply_id;
}
