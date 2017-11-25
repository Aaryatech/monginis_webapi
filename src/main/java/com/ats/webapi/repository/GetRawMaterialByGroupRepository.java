package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.GetRawMaterialByGroup;

public interface GetRawMaterialByGroupRepository extends JpaRepository<GetRawMaterialByGroup, Integer>{
	
	@Query(value=" select r.rm_id, r.rm_name, r.rm_gst_per, r.grp_id, g.grp_name, r.cat_id, c.cat_name, r.sub_cat_id,"
			+" s.sub_cat_name, r.rm_pack_qty, r.rm_rate, r.rm_is_critical from m_rm r, m_rm_item_cat c, m_rm_item_group g,"
			+" m_rm_item_sub_cat s where r.grp_id=g.grp_id AND r.cat_id=c.cat_id AND s.sub_cat_id=r.sub_cat_id AND r.grp_id=:grpId AND del_status=0 "
			+ "",nativeQuery=true)
	List<GetRawMaterialByGroup> getRmByGroup(@Param("grpId") int grpId);

}
