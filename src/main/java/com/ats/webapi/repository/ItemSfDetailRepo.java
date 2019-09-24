package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.ItemSfDetail;

public interface ItemSfDetailRepo extends JpaRepository<ItemSfDetail, Integer>{
	
	public ItemSfDetail save(ItemSfDetail itemSfDetail);
	
	List<ItemSfDetail> findByDelStatusAndSfId(int delStatus,int sfId);


	@Query(value="    SELECT\n" + 
			"        m_item_sf_detail.sf_did,\n" + 
			"        m_item_sf_detail.sf_id,\n" + 
			"         m_item_sf_detail.rm_id,\n" + 
			"        concat(m_item_sf_detail.rm_name,'#',m_rm_uom.uom) as rm_name,\n" + 
			"        m_item_sf_detail.rm_type,\n" + 
			"        m_item_sf_detail.rm_qty,\n" + 
			"        m_item_sf_detail.rm_weight,\n" + 
			"        m_item_sf_detail.del_status,\n" + 
			"        m_item_sf_detail.rm_unit\n" + 
			"    FROM\n" + 
			"        m_item_sf_detail,m_rm_uom" + 
			"    WHERE\n" + 
			"        m_item_sf_detail.sf_id in(:sfId) and m_item_sf_detail.del_status=0 and m_rm_uom.uom=m_item_sf_detail.rm_unit" + 
			"    GROUP by\n" + 
			"        m_item_sf_detail.rm_id",nativeQuery=true)
	public List<ItemSfDetail> getSfItemDetailsForCreamPrep(@Param("sfId")List<Integer> sfId);

}
