package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>,JpaSpecificationExecutor<Item>  {

	public Item save(Item item);

	public Item findOne(int id);

	public List<Item> findByDelStatus(int i);


	public List<Item> findByItemGrp1(String itemGrp1);

	@Query(value="select * from m_item where item_id IN (:itemList) AND del_status=0",nativeQuery=true)
	public List<Item> findByDelStatusAndItemIdIn(@Param("itemList")List<Integer> itemList);

}
