package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.Item;

@Repository
public interface TallyItemRepository extends JpaRepository<Item, Long>{

	@Query(value="SELECT i.id,i.item_name,c.cat_name AS item_group,s.sub_cat_name AS sub_group ,i.item_grp3,i.item_tax1,i.item_tax2,i.item_tax3,sup.item_hsncd,sup.item_cess,sup.item_uom from m_item i,m_category c ,m_cat_sub s ,m_item_sup sup where i.id=sup.item_id AND i.item_grp1=c.cat_id AND i.item_grp2=s.sub_cat_id AND sup.is_tally_sync=0 AND i.del_status=0\n" + 
			"",nativeQuery=true)
	List<Item> findByIsTallySync();
}
