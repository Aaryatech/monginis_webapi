package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SpecialCake;


@Repository
public interface TallySpCakeRepository extends JpaRepository<SpecialCake, Long>{

	
	@Query(value="SELECT s.sp_id,s.sp_name,s.sp_tax1,s.sp_tax2,s.sp_tax3,sup.sp_hsncd,sup.sp_cess,sup.sp_uom from m_sp_cake s,m_spcake_sup sup where s.sp_id=sup.sp_id AND sup.is_tally_sync=0 AND s.del_status=0",nativeQuery=true)
	List<SpecialCake> findByIsTallySync();
	

}
