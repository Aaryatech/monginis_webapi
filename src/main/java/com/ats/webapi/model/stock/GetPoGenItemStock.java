package com.ats.webapi.model.stock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class GetPoGenItemStock implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="store_stock_detail_id")
	private int storeStockDetailId;
	
	@Column(name="store_opening_stock")
	private float storeOpeningStock;
	
	@Column(name="store_closing_stock")
	private float storeClosingStock;
	
	@Column(name="store_stock_date")
	private Date storeStockDate;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_code")
	private String rmCode;
	
	@Column(name="rm_min_qty")
	private float rmMinQty;
	
	@Column(name="rm_max_qty")
	private float rmMaxQty;
	
	@Column(name="rm_rol_qty")
	private float rmRolQty;
	
	@Column(name="pur_rec_qty")
	private float purRecQty;

	@Column(name="bms_issue_qty")
	private float bmsIssueQty;
	
	@Column(name="po_no")
	private int poNo;

	@Column(name="po_qty")
	private int poQty;

	public int getStoreStockDetailId() {
		return storeStockDetailId;
	}

	public float getStoreOpeningStock() {
		return storeOpeningStock;
	}

	public float getStoreClosingStock() {
		return storeClosingStock;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getStoreStockDate() {
		return storeStockDate;
	}

	public int getRmId() {
		return rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public String getRmCode() {
		return rmCode;
	}

	public float getRmMinQty() {
		return rmMinQty;
	}

	public float getRmMaxQty() {
		return rmMaxQty;
	}

	public float getRmRolQty() {
		return rmRolQty;
	}

	public float getPurRecQty() {
		return purRecQty;
	}

	public float getBmsIssueQty() {
		return bmsIssueQty;
	}

	public int getPoNo() {
		return poNo;
	}

	public int getPoQty() {
		return poQty;
	}

	public void setStoreStockDetailId(int storeStockDetailId) {
		this.storeStockDetailId = storeStockDetailId;
	}

	public void setStoreOpeningStock(float storeOpeningStock) {
		this.storeOpeningStock = storeOpeningStock;
	}

	public void setStoreClosingStock(float storeClosingStock) {
		this.storeClosingStock = storeClosingStock;
	}

	public void setStoreStockDate(Date storeStockDate) {
		this.storeStockDate = storeStockDate;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public void setRmMinQty(float rmMinQty) {
		this.rmMinQty = rmMinQty;
	}

	public void setRmMaxQty(float rmMaxQty) {
		this.rmMaxQty = rmMaxQty;
	}

	public void setRmRolQty(float rmRolQty) {
		this.rmRolQty = rmRolQty;
	}

	public void setPurRecQty(float purRecQty) {
		this.purRecQty = purRecQty;
	}

	public void setBmsIssueQty(float bmsIssueQty) {
		this.bmsIssueQty = bmsIssueQty;
	}

	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}

	public void setPoQty(int poQty) {
		this.poQty = poQty;
	}

	@Override
	public String toString() {
		return "GetPoGenItemStock [storeStockDetailId=" + storeStockDetailId + ", storeOpeningStock="
				+ storeOpeningStock + ", storeClosingStock=" + storeClosingStock + ", storeStockDate=" + storeStockDate
				+ ", rmId=" + rmId + ", rmName=" + rmName + ", rmCode=" + rmCode + ", rmMinQty=" + rmMinQty
				+ ", rmMaxQty=" + rmMaxQty + ", rmRolQty=" + rmRolQty + ", purRecQty=" + purRecQty + ", bmsIssueQty="
				+ bmsIssueQty + ", poNo=" + poNo + ", poQty=" + poQty + "]";
	}
	
	
	
	
}
