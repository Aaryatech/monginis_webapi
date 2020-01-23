package com.ats.webapi.model.reportv2;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SubCatItemReport {

	@Id
	private String crndId;
	private int itemId;
	private String itemName;
	private int subCatId;
	private int catId;

	private int frId;
	private String frName;

	private String subCatName;

	private float soldQty;
	private float soldAmt;
	private float varQty;
	private float varAmt;

	private float retQty;
	private float retAmt;

	public String getCrndId() {
		return crndId;
	}

	public void setCrndId(String crndId) {
		this.crndId = crndId;
	}

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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public float getSoldQty() {
		return soldQty;
	}

	public void setSoldQty(float soldQty) {
		this.soldQty = soldQty;
	}

	public float getSoldAmt() {
		return soldAmt;
	}

	public void setSoldAmt(float soldAmt) {
		this.soldAmt = soldAmt;
	}

	public float getVarQty() {
		return varQty;
	}

	public void setVarQty(float varQty) {
		this.varQty = varQty;
	}

	public float getVarAmt() {
		return varAmt;
	}

	public void setVarAmt(float varAmt) {
		this.varAmt = varAmt;
	}

	public float getRetQty() {
		return retQty;
	}

	public void setRetQty(float retQty) {
		this.retQty = retQty;
	}

	public float getRetAmt() {
		return retAmt;
	}

	public void setRetAmt(float retAmt) {
		this.retAmt = retAmt;
	}

	@Override
	public String toString() {
		return "SubCatItemReport [crndId=" + crndId + ", itemId=" + itemId + ", itemName=" + itemName + ", subCatId="
				+ subCatId + ", catId=" + catId + ", frId=" + frId + ", frName=" + frName + ", subCatName=" + subCatName
				+ ", soldQty=" + soldQty + ", soldAmt=" + soldAmt + ", varQty=" + varQty + ", varAmt=" + varAmt
				+ ", retQty=" + retQty + ", retAmt=" + retAmt + "]";
	}

}
