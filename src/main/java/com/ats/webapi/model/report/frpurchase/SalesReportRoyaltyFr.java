package com.ats.webapi.model.report.frpurchase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesReportRoyaltyFr {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="fr_city")
	private String frCity;
	
	float tBillTaxableAmt;
	float tGrnTaxableAmt;
	float tGvnTaxableAmt;
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
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCity() {
		return frCity;
	}
	public void setFrCity(String frCity) {
		this.frCity = frCity;
	}
	public float gettBillTaxableAmt() {
		return tBillTaxableAmt;
	}
	public void settBillTaxableAmt(float tBillTaxableAmt) {
		this.tBillTaxableAmt = tBillTaxableAmt;
	}
	public float gettGrnTaxableAmt() {
		return tGrnTaxableAmt;
	}
	public void settGrnTaxableAmt(float tGrnTaxableAmt) {
		this.tGrnTaxableAmt = tGrnTaxableAmt;
	}
	public float gettGvnTaxableAmt() {
		return tGvnTaxableAmt;
	}
	public void settGvnTaxableAmt(float tGvnTaxableAmt) {
		this.tGvnTaxableAmt = tGvnTaxableAmt;
	}
	@Override
	public String toString() {
		return "SalesReportRoyaltyFr [frId=" + frId + ", frCode=" + frCode + ", frName=" + frName + ", frCity=" + frCity
				+ ", tBillTaxableAmt=" + tBillTaxableAmt + ", tGrnTaxableAmt=" + tGrnTaxableAmt + ", tGvnTaxableAmt="
				+ tGvnTaxableAmt + "]";
	}
	
	
	
}
