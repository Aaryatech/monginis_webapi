package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Item;
import com.ats.webapi.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	String jsonUser = "{}";

	public Item findItems(int id) {
		Item item=itemRepository.findOne(id);
		return item;
	}
	
	public ErrorMessage saveItem(Item item) {
		
		Item tempItem =null;
		ErrorMessage errorMessage=new ErrorMessage();
		try {
		/*	
			if (item != null||item.getId()!=0||item.getItemGrp1().equalsIgnoreCase("")||item.getItemGrp2().equalsIgnoreCase("")||item.getItemGrp3().equalsIgnoreCase("")||item.getItemId().equalsIgnoreCase("")||item.getItemId().equalsIgnoreCase("")||item.getItemName().equalsIgnoreCase("")) {
				
				errorMessage.setError(false);
				errorMessage.setMessage("Item Inserted Successfully");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Item Fields are empty");
			}*/
			
				/*tempItem = itemRepository.findByItemId(item.getItemId());
				if(tempItem==null)
				{*/
					item= itemRepository.save(item);
					errorMessage.setError(false);
					errorMessage.setMessage("Item Inserted/Updated Successfully");
			/*	}
				else
				{
					errorMessage.setError(true);
					errorMessage.setMessage("Item Already Exist");
				}*/
		
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

	

}
