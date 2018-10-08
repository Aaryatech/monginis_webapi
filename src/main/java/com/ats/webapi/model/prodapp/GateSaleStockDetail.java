package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_gate_sale_stock_detail")
public class GateSaleStockDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gate_sale_stock_detail_id")
	private int gateSaleStockDetailId;
	
	private int gateSaleStockHeaderId;
	
	private Date stockDate;
	
	private int catId;
	private int subCatId;
	
	private float opQty;
	private float saleQty;
	private float inQty;
	private float closingQty;
	
	private int delStatus;

	public int getGateSaleStockDetailId() {
		return gateSaleStockDetailId;
	}

	public void setGateSaleStockDetailId(int gateSaleStockDetailId) {
		this.gateSaleStockDetailId = gateSaleStockDetailId;
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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public float getOpQty() {
		return opQty;
	}

	public void setOpQty(float opQty) {
		this.opQty = opQty;
	}

	public float getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(float saleQty) {
		this.saleQty = saleQty;
	}

	public float getInQty() {
		return inQty;
	}

	public void setInQty(float inQty) {
		this.inQty = inQty;
	}

	public float getClosingQty() {
		return closingQty;
	}

	public void setClosingQty(float closingQty) {
		this.closingQty = closingQty;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GateSaleStockDetail [gateSaleStockDetailId=" + gateSaleStockDetailId + ", gateSaleStockHeaderId="
				+ gateSaleStockHeaderId + ", stockDate=" + stockDate + ", catId=" + catId + ", subCatId=" + subCatId
				+ ", opQty=" + opQty + ", saleQty=" + saleQty + ", inQty=" + inQty + ", closingQty=" + closingQty
				+ ", delStatus=" + delStatus + "]";
	}

	

}
