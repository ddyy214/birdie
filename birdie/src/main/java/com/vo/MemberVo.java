package com.vo;

import lombok.Data;

@Data
public class MemberVo {
	private int mem_no;
	private String mem_id;
	private String mem_password;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	private int mem_score;
	
	//디폴트생성자
	public MemberVo() {}
	
}