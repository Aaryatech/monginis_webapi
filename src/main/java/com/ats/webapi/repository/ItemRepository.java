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

	@Query(value = "select id   ,\n" + "  item_id   ,\n" + "  item_name   ,\n" + "  item_grp1  ,\n" + "  item_grp2  ,\n"
			+ "  item_grp3   ,\n" + "  item_rate1   ,\n" + "  item_rate2   ,\n" + "  item_rate3   ,\n"
			+ "  item_mrp1   ,\n" + "  item_mrp2  ,\n" + "  item_mrp3   ,\n" + "  item_image   ,\n" + "  item_tax1  ,\n"
			+ "  item_tax2  ,\n" + "  item_tax3  ,\n" + "  item_is_used  ,\n" + "  item_sort_id   ,\n" + "  grn_two ,\n"
			+ "  del_status  ,\n" + "  min_qty  ,\n"
			+ "  item_shelf_life  from m_item  where m_item.id IN (:itemIdList) AND m_item.del_status=0", nativeQuery = true)
	public List<Item> findByIdInAndDelStatusOrderByItemGrp2AscItemSortIdAscNew(List<Integer> itemIdList, int i);

}
