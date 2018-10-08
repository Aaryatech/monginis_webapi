package com.ats.webapi.model.prodapp;

public class GateSaleStockEntry {
	
	
	int catId;
	int subCatId;
	int qty;//ie opQty
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "GateSaleStockEntry [catId=" + catId + ", subCatId=" + subCatId + ", qty=" + qty + "]";
	}
	

	
}
