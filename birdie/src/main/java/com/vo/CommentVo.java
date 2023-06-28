package com.vo;

import java.sql.Date;

public class CommentVo {
	private int qna_no;
	private int mem_no;
	private String cmt_content;
	private Date cmt_date;
	
	//디폴트 생성자
	public CommentVo () {}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public Date getCmt_date() {
		return cmt_date;
	}

	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	
}
