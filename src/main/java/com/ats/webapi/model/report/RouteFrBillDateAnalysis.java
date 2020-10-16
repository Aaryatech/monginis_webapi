package com.ats.webapi.model.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RouteFrBillDateAnalysis {

	@Id
	private String uniqueId;
	
	private int frId;
	private String frName;
	private String frCode;
	private int frRouteId;
	
	private Date billDate;
	private float grandTotal;
	
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public int getFrRouteId() {
		return frRouteId;
	}
	public void setFrRouteId(int frRouteId) {
		this.frRouteId = frRouteId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	@Override
	public String toString() {
		return "RouteFrBillDateAnalysis [uniqueId=" + uniqueId + ", frId=" + frId + ", frName=" + frName + ", frCode="
				+ frCode + ", frRouteId=" + frRouteId + ", billDate=" + billDate + ", grandTotal=" + grandTotal + "]";
	}
}

/*
 SELECT UUID() as unique_id, m_franchisee.fr_id,m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_route_id,
t_bill_header.bill_date,t_bill_header.grand_total
FROM m_franchisee,t_bill_header
WHERE t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.del_status=0 AND t_bill_header.bill_date BETWEEN '2020-09-01' AND '2020-09-10' ORDER BY t_bill_header.bill_date,
m_franchisee.fr_route_id*/
