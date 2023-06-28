package com.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class PayVo {
	private int mem_no;
	private int reservation_no;
	private int pay_price;
	private Date pay_date;
	
	//디폴트 생성자
	public PayVo() {}
}