package com.wqm.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicVo implements Serializable {
     public Integer id;

     public String username;

     public String avatar;

     public Integer mid;

     String message;

     LocalDateTime time;

     Integer uid;

     public List<CommentVo> reply ;
}
