package com.ats.webapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SpCakeImageReport {

	@Id
	private int spOrderNo;
	
	private float spSelectedWeight;
	private String orderPhoto;
	private String orderPhoto2;
	
	private int spId;
	
	private Date orderDate;
	private Date spDeliveryDate;
	private String spCode;
	private String spName;
	private String frName;
	private String frCode;
	
	private String spfName;

	public int getSpOrderNo() {
		return spOrderNo;
	}

	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
	}

	public float getSpSelectedWeight() {
		return spSelectedWeight;
	}

	public void setSpSelectedWeight(float spSelectedWeight) {
		this.spSelectedWeight = spSelectedWeight;
	}

	public String getOrderPhoto() {
		return orderPhoto;
	}

	public void setOrderPhoto(String orderPhoto) {
		this.orderPhoto = orderPhoto;
	}

	public String getOrderPhoto2() {
		return orderPhoto2;
	}

	public void setOrderPhoto2(String orderPhoto2) {
		this.orderPhoto2 = orderPhoto2;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
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

	public String getSpfName() {
		return spfName;
	}

	public void setSpfName(String spfName) {
		this.spfName = spfName;
	}

	@Override
	public String toString() {
		return "SpCakeImageReport [spOrderNo=" + spOrderNo + ", spSelectedWeight=" + spSelectedWeight + ", orderPhoto="
				+ orderPhoto + ", orderPhoto2=" + orderPhoto2 + ", spId=" + spId + ", orderDate=" + orderDate
				+ ", spDeliveryDate=" + spDeliveryDate + ", spCode=" + spCode + ", spName=" + spName + ", frName="
				+ frName + ", frCode=" + frCode + ", spfName=" + spfName + "]";
	}
	
	
	
	
}
