package com.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentVo {
	private int qna_no;
	private int mem_no;
	private String cmt_content;
	private Date cmt_date;
	
	//디폴트 생성자
	public CommentVo () {}

	
}
