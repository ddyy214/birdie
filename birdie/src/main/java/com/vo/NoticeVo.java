package com.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVo {
	private int mem_no;
	private int notice_no;
	private String notice_title;
	private Date notice_date;
	private String notice_content;
	
	//디폴트생성자
	public NoticeVo() {}
	
}