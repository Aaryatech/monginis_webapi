package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetDataForGateSaleDayEnd {
	
	
	@Id
	private int subCatId;
	
	private int catId;
	
	private String subCatName;
	private String catName;
	
	private float inQty;
	private float saleQty;
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public float getInQty() {
		return inQty;
	}
	public void setInQty(float inQty) {
		this.inQty = inQty;
	}
	public float getSaleQty() {
		return saleQty;
	}
	public void setSaleQty(float saleQty) {
		this.saleQty = saleQty;
	}
	@Override
	public String toString() {
		return "GetDataForGateSaleDayEnd [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName
				+ ", catName=" + catName + ", inQty=" + inQty + ", saleQty=" + saleQty + "]";
	}
	
	
	
	

}
