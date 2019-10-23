package com.ats.webapi.controller;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateAndQty {
	
	private float qty;
	private Date dlvDate;
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy") 
	public Date getDlvDate() {
		return dlvDate;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy") 
	public void setDlvDate(Date dlvDate) {
		this.dlvDate = dlvDate;
	}
	@Override
	public String toString() {
		return "DateAndQty [qty=" + qty + ", dlvDate=" + dlvDate + "]";
	}
	
	

}
