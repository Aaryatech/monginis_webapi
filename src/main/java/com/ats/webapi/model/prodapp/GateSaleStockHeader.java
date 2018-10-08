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
@Table(name="t_gate_sale_stock_header")
public class GateSaleStockHeader {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gate_sale_stock_header_id")
	private int gateSaleStockHeaderId;
	
	private Date stockDate;
	
	private int stockStatus;

	private int delStatus;
	
	@Transient
	List<GateSaleStockDetail> getGateSaleStockDetailList;
	
	

	public List<GateSaleStockDetail> getGetGateSaleStockDetailList() {
		return getGateSaleStockDetailList;
	}

	public void setGetGateSaleStockDetailList(List<GateSaleStockDetail> getGateSaleStockDetailList) {
		this.getGateSaleStockDetailList = getGateSaleStockDetailList;
	}

	public int getGateSaleStockHeaderId() {
		return gateSaleStockHeaderId;
	}

	public void setGateSaleStockHeaderId(int gateSaleStockHeaderId) {
		this.gateSaleStockHeaderId = gateSaleStockHeaderId;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
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

	@Override
	public String toString() {
		return "GateSaleStockHeader [gateSaleStockHeaderId=" + gateSaleStockHeaderId + ", stockDate=" + stockDate
				+ ", stockStatus=" + stockStatus + ", delStatus=" + delStatus + ", getGateSaleStockDetailList="
				+ getGateSaleStockDetailList + "]";
	}
	
	
	
	
}
