package com.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaVo {
	private int qna_no;
	private int member_no;
	private String qna_title;
	private Date qna_date;
	private String qna_content;
	
	//디폴트생성자
	public QnaVo() {}

}