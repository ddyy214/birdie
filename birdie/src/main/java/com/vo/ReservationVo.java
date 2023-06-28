package com.vo;

import java.sql.Date;

public class ReservationVo {
	private int res_no;
	private int mem_no;
	private Date res_date;
	
	//디폴트생성자
	public ReservationVo() {}

	public int getRes_no() {
		return res_no;
	}

	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public Date getRes_date() {
		return res_date;
	}

	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	
} 
	
	
