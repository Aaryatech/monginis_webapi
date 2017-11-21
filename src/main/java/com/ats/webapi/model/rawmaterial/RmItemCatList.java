package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class RmItemCatList implements Serializable{
	
	List<RmItemCategory> rmItemCategoryList;

	ErrorMessage errorMessage;

	public List<RmItemCategory> getRmItemCategoryList() {
		return rmItemCategoryList;
	}

	public void setRmItemCategoryList(List<RmItemCategory> rmItemCategoryList) {
		this.rmItemCategoryList = rmItemCategoryList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
