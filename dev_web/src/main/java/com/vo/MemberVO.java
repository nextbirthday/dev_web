package com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
    private String mem_no;
    private String mem_id;
    private String mem_pw;
    private String mem_name;
    private String mem_nick;
    private String mem_birth;
    private String mem_reg;
}
