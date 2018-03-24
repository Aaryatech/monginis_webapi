package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.tally.Franchisee;

public interface TallyFranchiseeRepository extends JpaRepository<Franchisee, Integer>{

	@Query(value="SELECT f.fr_id as customer_id,f.fr_name,f.fr_address,f.fr_city,s.fr_state,f.fr_gst_no,f.fr_code,s.fr_country,s.is_tally_sync FROM m_franchisee f,m_franchise_sup s WHERE f.fr_id=s.fr_id AND s.is_tally_sync=0 AND f.del_status=0",nativeQuery=true)
	List<Franchisee> findByIsTallySync();
	
}
