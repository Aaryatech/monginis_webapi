package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class ItemList implements Serializable{
	
	List<Item> itemList;
	ErrorMessage errorMessage;
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ItemList [itemList=" + itemList + ", errorMessage=" + errorMessage + "]";
	}

	
}
