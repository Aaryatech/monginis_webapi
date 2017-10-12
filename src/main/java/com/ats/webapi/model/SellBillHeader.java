package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name ="t_sell_bill_header")
public class SellBillHeader implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="invoice_no")
	private int invoiceNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="tax_applicable")
	private int taxApplicable;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="paid_amt")
	private float paidAmt;
	
	@Column(name="remaining_amt")
	private float remainingAmt;
	
	@Column(name="payment_mode")
	private int paymentMode;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_gst_no")
	private String userGstNo;
	
	@Column(name="user_phone")
	private int userPhone;
	
	@Column(name="status")
	private int status;
	
	@Column(name="del_status")
	private int DelStatus;


	@Transient
	List<SellBillDetail> sellBillDetailsList;
	
	public List<SellBillDetail> getSellBillDetailsList() {
		return sellBillDetailsList;
	}

	public void setSellBillDetailsList(List<SellBillDetail> sellBillDetailsList) {
		this.sellBillDetailsList = sellBillDetailsList;
	}

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public int getTaxApplicable() {
		return taxApplicable;
	}

	public void setTaxApplicable(int taxApplicable) {
		this.taxApplicable = taxApplicable;
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

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public float getRemainingAmt() {
		return remainingAmt;
	}

	public void setRemainingAmt(float remainingAmt) {
		this.remainingAmt = remainingAmt;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGstNo() {
		return userGstNo;
	}

	public void setUserGstNo(String userGstNo) {
		this.userGstNo = userGstNo;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
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

	@Override
	public String toString() {
		return "SellBillHeader [sellBillNo=" + sellBillNo + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", frId=" + frId + ", frCode=" + frCode + ", taxableAmt=" + taxableAmt + ", taxApplicable="
				+ taxApplicable + ", totalTax=" + totalTax + ", grandTotal=" + grandTotal + ", paidAmt=" + paidAmt
				+ ", remainingAmt=" + remainingAmt + ", paymentMode=" + paymentMode + ", userName=" + userName
				+ ", userGstNo=" + userGstNo + ", userPhone=" + userPhone + ", status=" + status + ", DelStatus="
				+ DelStatus + "]";
	}
	
	
}
