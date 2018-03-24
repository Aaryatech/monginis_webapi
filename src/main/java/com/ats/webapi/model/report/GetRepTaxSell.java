package com.ats.webapi.model.report;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetRepTaxSell {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sell_bill_detail_no")
		private int sellBillDetailNo;
	
	@Column(name="sell_bill_no")
	private int sellBillNo;
	
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;
	
	private float tax_amount;
	
	private float tax_per;

	@Column(name="user_gst_no")
	private String gstn;
	
	
	private float bill_amount;
	
	
	private float igst;
	
	
	private float cgst;
	
	
	private float sgst;

	@Transient
	private float cess;

	public int getSellBillDetailNo() {
		return sellBillDetailNo;
	}

	public void setSellBillDetailNo(int sellBillDetailNo) {
		this.sellBillDetailNo = sellBillDetailNo;
	}

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
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

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public float getTax_amount() {
		return tax_amount;
	}

	public void setTax_amount(float tax_amount) {
		this.tax_amount = tax_amount;
	}

	public float getTax_per() {
		return tax_per;
	}

	public void setTax_per(float tax_per) {
		this.tax_per = tax_per;
	}

	public String getGstn() {
		return gstn;
	}

	public void setGstn(String gstn) {
		this.gstn = gstn;
	}

	public float getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	@Override
	public String toString() {
		return "GetRepTaxSell [sellBillDetailNo=" + sellBillDetailNo + ", sellBillNo=" + sellBillNo + ", billDate="
				+ billDate + ", frId=" + frId + ", frName=" + frName + ", tax_amount=" + tax_amount + ", tax_per="
				+ tax_per + ", gstn=" + gstn + ", bill_amount=" + bill_amount + ", igst=" + igst + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", cess=" + cess + "]";
	}
	
	
	
}
