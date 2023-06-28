package com.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReservationVo {
	private int res_no;
	private int mem_no;
	private Date res_date;
	
	//디폴트생성자
	public ReservationVo() {}

}