package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNote;

public interface GrnGvnForCreditNoteRepositoty extends JpaRepository<GetGrnGvnForCreditNote, Integer>{
	
	
	@Query(value = " \n" + 
			"SELECT t_grn_gvn.* ,CASE WHEN t_grn_gvn.cat_id=5 THEN s.sp_name \n" + 
			"ELSE  m_item.item_name END AS item_name,m_franchisee.fr_name FROM m_franchisee,\n" + 
			"			m_item,t_grn_gvn,m_sp_cake s WHERE t_grn_gvn.fr_id=m_franchisee.fr_id AND \n" + 
			"			 CASE WHEN t_grn_gvn.cat_id=5 THEN t_grn_gvn.item_id=s.sp_id ELSE\n" + 
			" t_grn_gvn.item_id=m_item.id END AND \n" + 
			"			t_grn_gvn.is_credit_note=0  AND t_grn_gvn.grn_gvn_status=6  group by  t_grn_gvn.grn_gvn_id "
			, nativeQuery = true)
	
	List<GetGrnGvnForCreditNote> getGrnGvnDetailForCreditNote();
	
	
	

}
