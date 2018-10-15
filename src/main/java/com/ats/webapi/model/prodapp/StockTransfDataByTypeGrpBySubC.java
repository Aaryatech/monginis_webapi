package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockTransfDataByTypeGrpBySubC {
	
	@Id
	private int subCatId;
	
	
	private int catId;
	
	
	
	private float qty;
	
	private float aprQty1;
	private float aprQty2;
	private float aprQty3;
	

	private String subCatName;
	private String catName;
	
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
	
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public float getAprQty1() {
		return aprQty1;
	}
	public void setAprQty1(float aprQty1) {
		this.aprQty1 = aprQty1;
	}
	public float getAprQty2() {
		return aprQty2;
	}
	public void setAprQty2(float aprQty2) {
		this.aprQty2 = aprQty2;
	}
	public float getAprQty3() {
		return aprQty3;
	}
	public void setAprQty3(float aprQty3) {
		this.aprQty3 = aprQty3;
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
	@Override
	public String toString() {
		return "StockTransfDataByTypeGrpByItem [subCatId=" + subCatId + ", catId=" + catId + ", qty=" + qty
				+ ", aprQty1=" + aprQty1 + ", aprQty2=" + aprQty2 + ", aprQty3=" + aprQty3 + ", subCatName="
				+ subCatName + ", catName=" + catName + "]";
	}
	

	
}
