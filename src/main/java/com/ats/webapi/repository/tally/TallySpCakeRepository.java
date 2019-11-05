package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SpecialCakeTally;


@Repository
public interface TallySpCakeRepository extends JpaRepository<SpecialCakeTally, Long>{

	
	@Query(value="SELECT\n" + 
			"        s.sp_id,\n" + 
			"        s.sp_name,\n" + 
			"        s.sp_tax1,\n" + 
			"        s.sp_tax2,\n" + 
			"        s.sp_tax3,\n" + 
			"        sup.sp_hsncd,\n" + 
			"        sup.sp_cess,\n" + 
			"        sup.sp_uom,\n" + 
			"        s.sp_code,\n" + 
			"        s.sp_rate1,\n" + 
			"        s.sp_rate2,\n" + 
			"        s.sp_rate3,\n" + 
			"        s.mrp_rate1,\n" + 
			"        s.mrp_rate2,\n" + 
			"        s.mrp_rate3,s.erp_link_code \n" + 
			"    from\n" + 
			"        m_sp_cake s,\n" + 
			"        m_spcake_sup sup \n" + 
			"    where\n" + 
			"        s.sp_id=sup.sp_id \n" + 
			"        AND sup.is_tally_sync=0 \n" + 
			"        AND s.del_status=0",nativeQuery=true)
	List<SpecialCakeTally> findByIsTallySync();
	
	@Query(value="SELECT\n" + 
			"    s.sp_id,\n" + 
			"    s.sp_name,\n" + 
			"    s.sp_tax1,\n" + 
			"    s.sp_tax2,\n" + 
			"    s.sp_tax3,\n" + 
			"    sup.sp_hsncd,\n" + 
			"    sup.sp_cess,\n" + 
			"    sup.sp_uom,\n" + 
			"    s.sp_code,\n" + 
			"    s.sp_rate1,\n" + 
			"    s.sp_rate2,\n" + 
			"    s.sp_rate3,\n" + 
			"    s.mrp_rate1,\n" + 
			"    s.mrp_rate2,\n" + 
			"    s.mrp_rate3,\n" + 
			"    s.erp_link_code,\n" + 
			"    0 AS is_album\n" + 
			"FROM\n" + 
			"    m_sp_cake s,\n" + 
			"    m_spcake_sup sup\n" + 
			"WHERE\n" + 
			"    s.sp_id = sup.sp_id AND sup.is_tally_sync = 0 AND s.del_status = 0\n" + 
			"UNION\n" + 
			"SELECT\n" + 
			"    a.album_id AS sp_id,\n" + 
			"    a.album_name AS sp_name,\n" + 
			"    s.sp_tax1,\n" + 
			"    s.sp_tax2,\n" + 
			"    s.sp_tax3,\n" + 
			"    sup.sp_hsncd,\n" + 
			"    sup.sp_cess,\n" + 
			"    sup.sp_uom,\n" + 
			"    a.album_code AS sp_code,\n" + 
			"    s.sp_rate1,\n" + 
			"    s.sp_rate2,\n" + 
			"    s.sp_rate3,\n" + 
			"    s.mrp_rate1,\n" + 
			"    s.mrp_rate2,\n" + 
			"    s.mrp_rate3,\n" + 
			"    s.erp_link_code,\n" + 
			"    1 AS is_album\n" + 
			"FROM\n" + 
			"    t_sp_cake_album a,\n" + 
			"    m_sp_cake_category s,\n" + 
			"    m_spcake_category_sup sup\n" + 
			"WHERE\n" + 
			"    a.sp_id = s.sp_id AND s.sp_id = sup.sp_id AND sup.is_tally_sync = 0 AND s.del_status = 0 AND a.del_status = 0",nativeQuery=true)
	List<SpecialCakeTally> findByIsTallySyncSpAndAlbum();
	

}
