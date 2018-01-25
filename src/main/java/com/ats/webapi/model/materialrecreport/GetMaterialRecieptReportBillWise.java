package com.ats.webapi.model.materialrecreport;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetMaterialRecieptReportBillWise {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="mrn_no")
	private String mrnNo;
	
	@Column(name="inv_book_date")
	private Date invBookDate;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="inv_date")
	private Date invDate;
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="supp_name")
	private String suppName;
	
	@Column(name="supp_city")
	private String suppCity;
	
	@Column(name="supp_gstin")
	private String suppGstin;
	
	@Column(name="basic_value")
	private float basicValue;
	
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="freight_amt")
	private float freightAmt;
	
	@Column(name="insurance_amt")
	private float insuranceAmt;
	
	@Column(name="other")
	private float other;
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Column(name="bill_amount")
	private float billAmount;
	
	@Column(name="cess")
	private float cess;
	
	
	

	public float getOther() {
		return other;
	}

	public void setOther(float other) {
		this.other = other;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvBookDate() {
		return invBookDate;
	}

	public void setInvBookDate(Date invBookDate) {
		this.invBookDate = invBookDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppCity() {
		return suppCity;
	}

	public void setSuppCity(String suppCity) {
		this.suppCity = suppCity;
	}

	public String getSuppGstin() {
		return suppGstin;
	}

	public void setSuppGstin(String suppGstin) {
		this.suppGstin = suppGstin;
	}

	public float getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsuranceAmt() {
		return insuranceAmt;
	}

	public void setInsuranceAmt(float insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
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

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "GetMaterialRecieptReportBillWise [mrnId=" + mrnId + ", mrnNo=" + mrnNo + ", invBookDate=" + invBookDate
				+ ", invoiceNumber=" + invoiceNumber + ", invDate=" + invDate + ", supplierId=" + supplierId
				+ ", suppName=" + suppName + ", suppCity=" + suppCity + ", suppGstin=" + suppGstin + ", basicValue="
				+ basicValue + ", discAmt=" + discAmt + ", freightAmt=" + freightAmt + ", insuranceAmt=" + insuranceAmt
				+ ", other=" + other + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", roundOff=" + roundOff
				+ ", billAmount=" + billAmount + ", cess=" + cess + "]";
	}
	
	
	
	

}
