package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNote;

public interface GrnGvnForCreditNoteRepositoty extends JpaRepository<GetGrnGvnForCreditNote, Integer>{
	
	
	@Query(value = " SELECT t_grn_gvn.* ,m_item.item_name,m_franchisee.fr_name FROM m_franchisee,"
			+ "m_item,t_grn_gvn WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND "
			+ "t_grn_gvn.item_id=m_item.id AND "
			+ " t_grn_gvn.is_credit_note=0  AND t_grn_gvn.grn_gvn_status=7 AND t_grn_gvn.is_credit_note=0 "
			, nativeQuery = true)
	
	List<GetGrnGvnForCreditNote> getGrnGvnDetailForCreditNote();
	
	
	

}
