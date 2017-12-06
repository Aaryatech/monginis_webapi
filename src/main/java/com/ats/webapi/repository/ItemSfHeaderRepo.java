package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.ItemSfHeader;

public interface ItemSfHeaderRepo extends JpaRepository<ItemSfHeader, Integer>{

	ItemSfHeader save(ItemSfHeader itemSfHeader);
	
	
}
