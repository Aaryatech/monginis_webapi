package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

// Bean to insert bill :

@Entity
@Table(name = "t_bill_header")
public class PostBillHeader implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	private int billNo;
		
	@Column(name="tax_applicable")
	private int taxApplicable;
	
	@Column(name="invoice_no")
	private int invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="total")
	private float total;
	
	@Column(name="total_without_tax")
	private float totalWithoutTax;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="status")
	private int status;
	
	
	@Column(name="del_status")
	private int DelStatus;
	
	@Column(name="remark")
	private String remark;

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotalWithoutTax() {
		return totalWithoutTax;
	}

	public void setTotalWithoutTax(float totalWithoutTax) {
		this.totalWithoutTax = totalWithoutTax;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelStatus() {
		return DelStatus;
	}

	public void setDelStatus(int delStatus) {
		DelStatus = delStatus;
	}

	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getTaxApplicable() {
		return taxApplicable;
	}

	public void setTaxApplicable(int taxApplicable) {
		this.taxApplicable = taxApplicable;
	}

	
	// constructor remove after testing
	public PostBillHeader(int billNo, int taxApplicable, int invoiceNo, Date billDate, int frId, String frCode,
			float total, float totalWithoutTax, float totalTax, int status, int delStatus, String remark) {
		super();
		this.billNo = billNo;
		this.taxApplicable = taxApplicable;
		this.invoiceNo = invoiceNo;
		this.billDate = billDate;
		this.frId = frId;
		this.frCode = frCode;
		this.total = total;
		this.totalWithoutTax = totalWithoutTax;
		this.totalTax = totalTax;
		this.status = status;
		DelStatus = delStatus;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "PostBillHeader [billNo=" + billNo + ", taxApplicable=" + taxApplicable + ", invoiceNo=" + invoiceNo
				+ ", billDate=" + billDate + ", frId=" + frId + ", frCode=" + frCode + ", total=" + total
				+ ", totalWithoutTax=" + totalWithoutTax + ", totalTax=" + totalTax + ", status=" + status
				+ ", DelStatus=" + DelStatus + ", remark=" + remark + "]";
	}
	

	
	
	
	
	
	
}
