package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	public Item save(Item item);

	public Item findOne(int id);

	public List<Item> findByItemGrp1AndDelStatusOrderByItemNameAsc(String itemGrp1,int i);

	@Query(value="select * from m_item where m_item.id IN (:itemList) AND m_item.del_status=0",nativeQuery=true)
	public List<Item> findByDelStatusAndItemIdIn(@Param("itemList")List<Integer> itemList);

	public List<Item> findByDelStatusOrderByItemNameAsc(int i);

}
