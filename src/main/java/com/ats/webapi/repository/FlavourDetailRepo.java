package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.flavour.FlavourDetail;
@Repository
public interface FlavourDetailRepo extends JpaRepository<FlavourDetail, Integer> {

	@Query(value="SELECT\n" + 
			"        i.spf_name as varchar_2,\n" + 
			"        d.flavour_detail_id,\n" + 
			"        d.flavour_id,\n" + 
			"        d.flavour_name,\n" + 
			"        d.rm_type,\n" + 
			"        d.rm_id,\n" + 
			"        d.rm_name,\n" + 
			"        d.rm_uom_id,\n" + 
			"        d.rm_qty,\n" + 
			"        d.rm_weight,\n" + 
			"        d.no_pieces_per_flavour,\n" + 
			"        d.sequence_no,\n" + 
			"        d.del_status,\n" + 
			"        d.int_1,\n" + 
			"        d.int_2,\n" + 
			"        d.boll1,\n" + 
			"        d.boll2,d.varchar_1          \n" + 
			"    FROM\n" + 
			"        m_flavour_detail d,\n" + 
			"        m_sp_flavour i          \n" + 
			"    WHERE\n" + 
			"        i.spf_id=d.flavour_id  \n" + 
			"        AND   d.flavour_id=:id\n" + 
			"        AND   d.del_status=0",nativeQuery=true)
	List<FlavourDetail> getFlavourDetails(@Param("id") int id);

	
}
