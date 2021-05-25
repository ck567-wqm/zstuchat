package com.wqm.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MyFriendVo implements Serializable {
    String username;
    String avatar;
    String signature;
    LocalDateTime time;
}
