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

	public List<Item> findByItemGrp1AndDelStatusOrderByItemNameAsc(String itemGrp1, int i);

	@Query(value = "select * from m_item where m_item.id IN (:itemList) AND m_item.del_status=0", nativeQuery = true)
	public List<Item> findByDelStatusAndItemIdIn(@Param("itemList") List<Integer> itemList);

	public List<Item> findByDelStatusOrderByItemGrp2(int i);// changed to order by subcatId 21/Apr

	@Query(value = "select MAX(item_id)+1 from m_item", nativeQuery = true)
	public int findMaxId();

	public List<Item> findByItemGrp1AndDelStatusOrderByItemGrp2AscItemSortIdAsc(String itemGrp1, int i);

	public List<Item> findByDelStatusOrderByItemGrp2AscItemSortIdAsc(int i);

	@Query(value = "select * from m_item where m_item.id IN (Select m_item_sup.item_id from m_item_sup where m_item_sup.is_allow_bday=:isAllowBday) AND m_item.del_status=:delStatus", nativeQuery = true)
	public List<Item> findByIsAllowBirthayAndDelStatus(@Param("isAllowBday") int isAllowBday,
			@Param("delStatus") int delStatus);

	@Query(value = "select m_item.* from m_item where m_item.del_status=0 And m_item.item_grp1=:itemGrp1 And m_item.id not in(select m_item_sup.item_id from m_item_sup where m_item_sup.del_status=0) order by m_item.item_name ", nativeQuery = true)
	public List<Item> findByItemGrp1(@Param("itemGrp1") String itemGrp1);

	@Query(value = "select * from m_item where m_item.id IN (:itemList)", nativeQuery = true)
	public List<Item> findAllItems(@Param("itemList") List<Integer> itemList);

	public List<Item> findByItemGrp1InAndDelStatusOrderByItemGrp2AscItemSortIdAsc(List<String> catIdList, int i);

	public List<Item> findByItemGrp2OrderByItemGrp2(String subCatId);

	@Query(value = "select m.* from m_item m,m_item_sup s where m.id = s.item_id and s.is_gate_sale = 1 and m.del_status=0 and item_grp1 =:itemGrp1", nativeQuery = true)
	public List<Item> getItemsByCatIdForGateSale(@Param("itemGrp1") String itemGrp1);

	public List<Item> findByDelStatusAndIdIn(int i, List<Integer> itemids);

	public List<Item> findByIdInAndDelStatusOrderByItemGrp2AscItemSortIdAsc(List<Integer> itemIdList, int i);

	@Query(value = "select id,item_id,item_name,item_grp1,item_grp2,item_grp3,item_rate1,item_rate2,item_rate3,item_mrp1,item_mrp2,item_mrp3,(select s.station_id from m_station s where FIND_IN_SET(id,s.item_id) and s.del_status=0 and s.is_used=1) as item_image,item_tax1  ,item_tax2  ,item_tax3,item_is_used  ,\n" + 
			"item_sort_id,grn_two ,del_status  ,min_qty, item_shelf_life  from m_item  where m_item.id IN (:itemIdList) AND m_item.del_status=:delStatus order by m_item.item_grp2,m_item.item_name", nativeQuery = true)
	public List<Item> findByIdInAndDelStatusOrderByItemGrp2AscItemSortIdAscNew(@Param("itemIdList")List<Integer> itemIdList,@Param("delStatus") int i);

	@Query(value = "select m_item.* from m_item where m_item.del_status=0 and m_item.id In(select m_item_detail.item_id from m_item_detail where del_status=0 and m_item_detail.rm_id=:rmId and rm_type=:rmType)",nativeQuery=true)
	public List<Item> getItemsByRmIdAndRmType(@Param("rmId")int rmId,@Param("rmType") int rmType);

	@Query(value = "select m_item.* from m_item where m_item.del_status=0 And m_item.item_grp3=:itemGrp3 and m_item.id IN (select d.item_id from t_production_plan_detail d where d.production_header_id=:prodHeaderId group by d.item_id) order by m_item.item_name ", nativeQuery = true)
	public List<Item> findByItemGrp3(@Param("itemGrp3") String itemGrp3,@Param("prodHeaderId") int prodHeaderId);

}
