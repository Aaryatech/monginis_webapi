package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetItemSup;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.ItemSupList;
import com.ats.webapi.repository.GetItemSupRepository;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.ItemSupRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemSupRepository itemSupRepository;
	@Autowired
	private GetItemSupRepository getItemSupRepository;
	
	String jsonUser = "{}";

	public Item findItems(int id) {
		Item item=itemRepository.findOne(id);
		return item;
	}
	
	public ErrorMessage saveItem(Item item) {
		
		Item tempItem =null;
		ErrorMessage errorMessage=new ErrorMessage();
		try {
		
					item= itemRepository.save(item);
					errorMessage.setError(false);
					errorMessage.setMessage("Item Inserted/Updated Successfully");
		
		
		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Exc while saving Item");
		}
		return errorMessage;
	}

	
	public ItemsList findAllItems() {
		 List<Item> items=new ArrayList<Item>();
		 ItemsList itemsList=new ItemsList();
		ErrorMessage errorMessage=new ErrorMessage();
		items=itemRepository.findByDelStatus(0);
		if(items!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All items displayed successfully");
			itemsList.setErrorMessage(errorMessage);
			itemsList.setItems(items);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			itemsList.setErrorMessage(errorMessage);
		}
		
		return itemsList;
	}

	@Override
	public Item findItem(int id) {
		Item item=itemRepository.findOne(id);
		return item;
	}

	@Override
	public List<Item> findFrItems(String itemGrp1) {
		List<Item> items=itemRepository.findByItemGrp1AndDelStatus(itemGrp1,0);
		return items;
	}

	@Override
	public List<Item> getAllItems() {
		 List<Item> items=itemRepository.findByDelStatus(0);

		return items;
	}

	@Override
	public List<Item> findItemsByItemId(List<Integer> itemList) {

		
		 List<Item> items=itemRepository.findByDelStatusAndItemIdIn(itemList);
		return items;
	}

	@Override
	public ItemSup saveItemSup(ItemSup itemSup) {

		ItemSup itemSupRes=itemSupRepository.saveAndFlush(itemSup);
		
		return itemSupRes;
	}

	@Override
	public Info deleteItemSup(int itemId) {

		int isDel=itemSupRepository.deleteItemSup(itemId);
		Info info=new Info();
		if(isDel==1)
		{
			info.setError(false);
			info.setMessage("ItemSup Deleted Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("ItemSup Deletion Failed.");
		}
		return info;
	}

	@Override
	public ItemSupList getItemSupList() {

		ItemSupList itemSupList=new ItemSupList();
		try {
		List<GetItemSup> itemSupListRes=getItemSupRepository.findAllByDelStatus(0);
		
		if(!itemSupListRes.isEmpty())
		{
			Info info=new Info();
			info.setError(true);
			info.setMessage("ItemList Found Successfully.");
			
			itemSupList.setItemSupList(itemSupListRes);
			itemSupList.setInfo(info);
		}
		else
		{
			Info info=new Info();
			info.setError(true);
			info.setMessage("ItemList Not Found.");
			itemSupList.setInfo(info);

		}
		}
		catch(Exception e)
		{
			System.out.println("Exception In GetItemSup List ");
			e.printStackTrace();
			Info info=new Info();
			info.setError(true);
			info.setMessage("ItemList Not Found.");
			itemSupList.setInfo(info);
		}
		return itemSupList;
	}

	@Override
	public GetItemSup getItemSup(int id) {

		GetItemSup itemSup=getItemSupRepository.findGetItemSupById(id);
		return itemSup;
	}

	

}
