package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.ItemSfDetail;

public interface ItemSfDetailRepo extends JpaRepository<ItemSfDetail, Integer>{
	
	public ItemSfDetail save(ItemSfDetail itemSfDetail);

}
