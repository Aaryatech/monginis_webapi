package com.ats.webapi.service;


import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemWithSubCat;

public interface ItemService {

	public ErrorMessage saveItem(Item item);
	public Item findItems(int id);
	public ItemsList findAllItems();
	public Item findItem(int id);
	public List<Item> findFrItems(String itemGrp1);
	public List<Item> getAllItems();

}
