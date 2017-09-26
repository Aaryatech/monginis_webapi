package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ItemsWithCategory;
import com.ats.webapi.repository.ItemsWithCategoryRepository;


@Service
public class ItemsWithCategoryServiceImpl implements ItemsWithCategoryService {
		
	@Autowired
	ItemsWithCategoryRepository itemsWithCategoryRepository;

	@Override
	public List<ItemsWithCategory> getItemsAndCateName() {
		
		List<ItemsWithCategory> itemsWithCategoryList=itemsWithCategoryRepository.getAllItemsWithCategory();
		
		
		return itemsWithCategoryList;
	}

}
