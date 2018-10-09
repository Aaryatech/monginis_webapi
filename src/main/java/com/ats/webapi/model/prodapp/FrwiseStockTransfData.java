package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrwiseStockTransfData {
	
	@Id
	private int itemId;
	private String itemName;

	private int subCatId;
	private String subCatName;

	private int price;
	
	private float qty;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "FrwiseStockTransfData [itemId=" + itemId + ", itemName=" + itemName + ", subCatId=" + subCatId
				+ ", subCatName=" + subCatName + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
