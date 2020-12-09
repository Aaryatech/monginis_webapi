package com.ats.webapi.model;

public class SubCatWiseLimit {

	private int subCatId;
	private String subCatName;
	private int qtyLimit;

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

	public int getQtyLimit() {
		return qtyLimit;
	}

	public void setQtyLimit(int qtyLimit) {
		this.qtyLimit = qtyLimit;
	}

	@Override
	public String toString() {
		return "SubCatWiseLimit [subCatId=" + subCatId + ", subCatName=" + subCatName + ", qtyLimit=" + qtyLimit + "]";
	}

}
