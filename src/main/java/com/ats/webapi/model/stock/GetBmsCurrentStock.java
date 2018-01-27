package com.ats.webapi.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	@Override
	public String toString() {
		return "GetBmsCurrentStock [rmId=" + rmId + ", rmName=" + rmName + ", rmUomId=" + rmUomId + ", prod_issue_qty="
				+ prod_issue_qty + ", prod_rejected_qty=" + prod_rejected_qty + ", prod_return_qty=" + prod_return_qty
				+ ", mixing_issue_qty=" + mixing_issue_qty + ", mixing_rejected_qty=" + mixing_rejected_qty
				+ ", mixing_return_qty=" + mixing_return_qty + ", store_issue_qty=" + store_issue_qty
				+ ", store_rejected_qty=" + store_rejected_qty + ", openingQty=" + openingQty + "]";
	}
	float prod_issue_qty;
	float prod_rejected_qty;
	
	float prod_return_qty;
	float mixing_issue_qty;
	float mixing_rejected_qty; 
	float mixing_return_qty;
	float store_issue_qty; 
	float store_rejected_qty;
	
	@Transient
	float openingQty=0;
	
	
	
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
	public float getProd_issue_qty() {
		return prod_issue_qty;
	}
	public void setProd_issue_qty(float prod_issue_qty) {
		this.prod_issue_qty = prod_issue_qty;
	}
	public float getProd_rejected_qty() {
		return prod_rejected_qty;
	}
	public void setProd_rejected_qty(float prod_rejected_qty) {
		this.prod_rejected_qty = prod_rejected_qty;
	}
	public float getProd_return_qty() {
		return prod_return_qty;
	}
	public void setProd_return_qty(float prod_return_qty) {
		this.prod_return_qty = prod_return_qty;
	}
	public float getMixing_issue_qty() {
		return mixing_issue_qty;
	}
	public void setMixing_issue_qty(float mixing_issue_qty) {
		this.mixing_issue_qty = mixing_issue_qty;
	}
	public float getMixing_rejected_qty() {
		return mixing_rejected_qty;
	}
	public void setMixing_rejected_qty(float mixing_rejected_qty) {
		this.mixing_rejected_qty = mixing_rejected_qty;
	}
	public float getMixing_return_qty() {
		return mixing_return_qty;
	}
	public void setMixing_return_qty(float mixing_return_qty) {
		this.mixing_return_qty = mixing_return_qty;
	}
	public float getStore_issue_qty() {
		return store_issue_qty;
	}
	public void setStore_issue_qty(float store_issue_qty) {
		this.store_issue_qty = store_issue_qty;
	}
	public float getStore_rejected_qty() {
		return store_rejected_qty;
	}
	public void setStore_rejected_qty(float store_rejected_qty) {
		this.store_rejected_qty = store_rejected_qty;
	}
	public float getOpeningQty() {
		return openingQty;
	}
	public void setOpeningQty(float openingQty) {
		this.openingQty = openingQty;
	}
	
}
