package com.ats.webapi.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
//rm stock bean 
@Entity
public class GetBmsCurrentStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rmId;
	

	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom_id")
	private int rmUomId;
	
	public int getRmUomId() {
		return rmUomId;
	}
	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}
	
	float prodIssueQty;
	float prodRejectedQty;
	
	float prodReturnQty;
	float mixingIssueQty;
	float mixingRejectedQty; 
	float mixingReturnQty;
	float storeIssueQty; 
	float storeRejectedQty;
	float bmsOpeningStock;
	
	float bmsClosingStock;
	
	

	
	public int getRmId() {
		return rmId;
	}
	public void setRmId(int rmId) {
		this.rmId = rmId;
	}
	public String getRmName() {
		return rmName;
	}
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}
	public float getProdIssueQty() {
		return prodIssueQty;
	}
	public void setProdIssueQty(float prodIssueQty) {
		this.prodIssueQty = prodIssueQty;
	}
	public float getProdRejectedQty() {
		return prodRejectedQty;
	}
	public void setProdRejectedQty(float prodRejectedQty) {
		this.prodRejectedQty = prodRejectedQty;
	}
	public float getProdReturnQty() {
		return prodReturnQty;
	}
	public void setProdReturnQty(float prodReturnQty) {
		this.prodReturnQty = prodReturnQty;
	}
	public float getMixingIssueQty() {
		return mixingIssueQty;
	}
	public void setMixingIssueQty(float mixingIssueQty) {
		this.mixingIssueQty = mixingIssueQty;
	}
	public float getMixingRejectedQty() {
		return mixingRejectedQty;
	}
	public void setMixingRejectedQty(float mixingRejectedQty) {
		this.mixingRejectedQty = mixingRejectedQty;
	}
	public float getMixingReturnQty() {
		return mixingReturnQty;
	}
	public void setMixingReturnQty(float mixingReturnQty) {
		this.mixingReturnQty = mixingReturnQty;
	}
	public float getStoreIssueQty() {
		return storeIssueQty;
	}
	public void setStoreIssueQty(float storeIssueQty) {
		this.storeIssueQty = storeIssueQty;
	}
	public float getStoreRejectedQty() {
		return storeRejectedQty;
	}
	public void setStoreRejectedQty(float storeRejectedQty) {
		this.storeRejectedQty = storeRejectedQty;
	}
	public float getBmsOpeningStock() {
		return bmsOpeningStock;
	}
	public void setBmsOpeningStock(float bmsQpeningStock) {
		this.bmsOpeningStock = bmsQpeningStock;
	}
	public float getBmsClosingStock() {
		return bmsClosingStock;
	}
	public void setBmsClosingStock(float bmsClosingStock) {
		this.bmsClosingStock = bmsClosingStock;
	}
	
	@Override
	public String toString() {
		return "GetBmsCurrentStock [rmId=" + rmId + ", rmName=" + rmName + ", rmUomId=" + rmUomId + ", prodIssueQty="
				+ prodIssueQty + ", prodRejectedQty=" + prodRejectedQty + ", prodReturnQty=" + prodReturnQty
				+ ", mixingIssueQty=" + mixingIssueQty + ", mixingRejectedQty=" + mixingRejectedQty
				+ ", mixingReturnQty=" + mixingReturnQty + ", storeIssueQty=" + storeIssueQty + ", storeRejectedQty="
				+ storeRejectedQty + ", bmsOpeningStock=" + bmsOpeningStock + ", bmsClosingStock=" + bmsClosingStock
				+ "]";
	}
	
	
}
