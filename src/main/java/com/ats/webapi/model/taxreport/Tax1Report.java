package com.ats.webapi.model.taxreport;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tax1Report implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
	
	private String invoiceNo;
	
	private Date billDate;
	
	private String frName;
	
	private String frGstNo;
	
	private int billNo;
	
	private float cgstPer;
	
	private float sgstPer;
	
	private float taxPer;
	
	private float taxableAmt;
	
	private float cgstAmt;

	private float sgstAmt;
	
	private float totalTax;
	
	private float grandTotal;

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrGstNo() {
		return frGstNo;
	}

	public void setFrGstNo(String frGstNo) {
		this.frGstNo = frGstNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(float taxPer) {
		this.taxPer = taxPer;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public float getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(float sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "Tax1Report [billDetailNo=" + billDetailNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", frName=" + frName + ", frGstNo=" + frGstNo + ", billNo=" + billNo + ", cgstPer=" + cgstPer
				+ ", sgstPer=" + sgstPer + ", taxPer=" + taxPer + ", taxableAmt=" + taxableAmt + ", cgstAmt=" + cgstAmt
				+ ", sgstAmt=" + sgstAmt + ", totalTax=" + totalTax + ", grandTotal=" + grandTotal + "]";
	}
	
	
	
	
}
