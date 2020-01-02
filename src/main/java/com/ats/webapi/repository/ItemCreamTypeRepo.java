package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.ItemCreamType;

public interface ItemCreamTypeRepo extends JpaRepository<ItemCreamType, Integer> {
	
	public List<ItemCreamType> findBydelStatus(int del);

	public ItemCreamType findByItemCreamIdAndDelStatus(int itemCreamId, int del);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE item_cream_type SET del_status=1 WHERE item_cream_id=:itemCreamId",nativeQuery=true)
	public int deleteItemCreamType(@Param("itemCreamId") int itemCreamId);
}
