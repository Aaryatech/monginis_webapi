package com.ats.webapi.model.report.frpurchase;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class CrnSalesReportDateWise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private String uid;
	private Date crnDate;
	private String monthName;
	private int frId;
	private float crnTaxableAmt;
	private float crnTotalTax;
	private float crnGrandTotal;
	private String frName;
	private String frCode;
	private int crnNo;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCrnDate() {
		return crnDate;
	}
	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public float getCrnTaxableAmt() {
		return crnTaxableAmt;
	}
	public void setCrnTaxableAmt(float crnTaxableAmt) {
		this.crnTaxableAmt = crnTaxableAmt;
	}
	public float getCrnTotalTax() {
		return crnTotalTax;
	}
	public void setCrnTotalTax(float crnTotalTax) {
		this.crnTotalTax = crnTotalTax;
	}
	public float getCrnGrandTotal() {
		return crnGrandTotal;
	}
	public void setCrnGrandTotal(float crnGrandTotal) {
		this.crnGrandTotal = crnGrandTotal;
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
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public int getCrnNo() {
		return crnNo;
	}
	public void setCrnNo(int crnNo) {
		this.crnNo = crnNo;
	}
	@Override
	public String toString() {
		return "CrnSalesReportDateWise [uid=" + uid + ", crnDate=" + crnDate + ", monthName=" + monthName + ", frId="
				+ frId + ", crnTaxableAmt=" + crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", crnGrandTotal="
				+ crnGrandTotal + ", frName=" + frName + ", frCode=" + frCode + ", crnNo=" + crnNo + "]";
	}
	
}
