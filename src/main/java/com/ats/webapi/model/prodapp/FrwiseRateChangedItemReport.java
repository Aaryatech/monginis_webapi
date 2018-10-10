package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


//report 6 on t_sp_cake_sup form ex_int =1 ie rate changed 
@Entity
public class FrwiseRateChangedItemReport {

	@Id
	private int tSpCakeSupNo;
	

	private String frName;
	private String frCode;
	private Date prodDate;
	
	
	private String spName;
	private String spCode;
	public int gettSpCakeSupNo() {
		return tSpCakeSupNo;
	}
	public void settSpCakeSupNo(int tSpCakeSupNo) {
		this.tSpCakeSupNo = tSpCakeSupNo;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProdDate() {
		return prodDate;
	}
	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	
	@Override
	public String toString() {
		return "FrwiseRateChangedItemReport [tSpCakeSupNo=" + tSpCakeSupNo + ", frName=" + frName + ", frCode=" + frCode
				+ ", prodDate=" + prodDate + ", spName=" + spName + ", spCode=" + spCode + "]";
	}
	
	
	
	
}
