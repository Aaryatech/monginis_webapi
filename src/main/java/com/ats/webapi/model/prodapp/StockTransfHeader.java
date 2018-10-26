package com.ats.webapi.model.prodapp;

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
@Table(name="t_stock_trasf_header")
public class StockTransfHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stock_transf_header_id")
	private int stockTransfHeaderId;
	
	private Date stockDate;
	
	private int type;
	private int userId;
	
	private int aprUserId1;
	private int aprUserId2;
	private int aprUserId3;
	
	private Date aprDate1;
	private Date aprDate2;
	private Date aprDate3;
	
	private int frId;
	
	private String frName;
	
	private int stockStatus;
	
	private int delStatus;
	
	private int exInt;
	private String exVar;
	private float exFloat;
	
	
	public int getStockTransfHeaderId() {
		return stockTransfHeaderId;
	}
	public void setStockTransfHeaderId(int stockTransfHeaderId) {
		this.stockTransfHeaderId = stockTransfHeaderId;
	}
	public Date getStockDate() {
		return stockDate;
	}
	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAprUserId1() {
		return aprUserId1;
	}
	public void setAprUserId1(int aprUserId1) {
		this.aprUserId1 = aprUserId1;
	}
	public int getAprUserId2() {
		return aprUserId2;
	}
	public void setAprUserId2(int aprUserId2) {
		this.aprUserId2 = aprUserId2;
	}
	public int getAprUserId3() {
		return aprUserId3;
	}
	public void setAprUserId3(int aprUserId3) {
		this.aprUserId3 = aprUserId3;
	}
	public Date getAprDate1() {
		return aprDate1;
	}
	public void setAprDate1(Date aprDate1) {
		this.aprDate1 = aprDate1;
	}
	public Date getAprDate2() {
		return aprDate2;
	}
	public void setAprDate2(Date aprDate2) {
		this.aprDate2 = aprDate2;
	}
	public Date getAprDate3() {
		return aprDate3;
	}
	public void setAprDate3(Date aprDate3) {
		this.aprDate3 = aprDate3;
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
	public int getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(int stockStatus) {
		this.stockStatus = stockStatus;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getExInt() {
		return exInt;
	}
	public void setExInt(int exInt) {
		this.exInt = exInt;
	}
	public String getExVar() {
		return exVar;
	}
	public void setExVar(String exVar) {
		this.exVar = exVar;
	}
	public float getExFloat() {
		return exFloat;
	}
	public void setExFloat(float exFloat) {
		this.exFloat = exFloat;
	}
	
	@Transient
	List<StockTransfDetail> stockTransfDetailList;
	
	public List<StockTransfDetail> getStockTransfDetailList() {
		return stockTransfDetailList;
	}
	public void setStockTransfDetailList(List<StockTransfDetail> stockTransfDetailList) {
		this.stockTransfDetailList = stockTransfDetailList;
	}
	
	
	
	@Override
	public String toString() {
		return "StockTransfHeader [stockTransfHeaderId=" + stockTransfHeaderId + ", stockDate=" + stockDate + ", type="
				+ type + ", userId=" + userId + ", aprUserId1=" + aprUserId1 + ", aprUserId2=" + aprUserId2
				+ ", aprUserId3=" + aprUserId3 + ", aprDate1=" + aprDate1 + ", aprDate2=" + aprDate2 + ", aprDate3="
				+ aprDate3 + ", frId=" + frId + ", frName=" + frName + ", stockStatus=" + stockStatus + ", delStatus="
				+ delStatus + ", exInt=" + exInt + ", exVar=" + exVar + ", exFloat=" + exFloat
				+ ", stockTransfDetailList=" + stockTransfDetailList + "]";
	}

}
