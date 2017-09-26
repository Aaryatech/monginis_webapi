package com.ats.webapi.model;

import java.util.List;

public class ItemsWithCategoryList {
	
	private  List<ItemsWithCategory> itemsWithCategories;
	private Info info;
	public List<ItemsWithCategory> getItemsWithCategories() {
		return itemsWithCategories;
	}
	public void setItemsWithCategories(List<ItemsWithCategory> itemsWithCategories) {
		this.itemsWithCategories = itemsWithCategories;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "ItemsWithCategoryList [itemsWithCategories=" + itemsWithCategories + ", info=" + info + "]";
	}
	
	
	

}
