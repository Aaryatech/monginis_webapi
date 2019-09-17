package com.ats.webapi.repository.getcreditnote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GetCrnDetails;
import com.ats.webapi.model.grngvn.PostCreditNoteDetails;

public interface GetCreditNoteDetailRepo extends JpaRepository<GetCrnDetails, Integer> {

/*	@Query(value = "SELECT detail.*,"
			+ "CASE WHEN detail.cat_id=5 THEN (SELECT m_sp_cake.sp_name from  m_sp_cake WHERE detail.item_id=m_sp_cake.sp_id)"
			+ "ELSE (SELECT m_item.item_name from m_item where m_item.id=detail.item_id) END AS item_name,"
			+ "CASE WHEN detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_hsncd from  m_spcake_sup WHERE detail.item_id=m_spcake_sup.sp_id)"
			+ "ELSE (SELECT m_item_sup.item_hsncd from m_item_sup where m_item_sup.item_id=detail.item_id) END AS item_hsncd,"
			+ "CASE WHEN detail.cat_id=5 THEN (SELECT m_spcake_sup.sp_uom from  m_spcake_sup WHERE detail.item_id=m_spcake_sup.sp_id)"
			+ "		ELSE (SELECT m_item_sup.item_uom from m_item_sup where m_item_sup.item_id=detail.item_id) END AS item_uom "
			+ " FROM t_credit_note_details detail " + "WHERE   detail.crn_id IN (:crnId) ", nativeQuery = true)

	List<GetCrnDetails> getCrnDetailsById(@Param("crnId") List<String> crnId);*/
	
	
	@Query(value = "SELECT\n" + 
			"    detail.*,\n" + 
			"    CASE WHEN detail.ex_int1 > 0 THEN SUBSTRING_INDEX(detail.ex_varchar1, '#', -1) ELSE CASE WHEN detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_sp_cake.sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake\n" + 
			"    WHERE\n" + 
			"        detail.item_id = m_sp_cake.sp_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item.item_name\n" + 
			"    FROM\n" + 
			"        m_item\n" + 
			"    WHERE\n" + 
			"        m_item.id = detail.item_id\n" + 
			")\n" + 
			"END\n" + 
			"END AS item_name,\n" + 
			"CASE WHEN detail.ex_int1 > 0 THEN(\n" + 
			"    SELECT\n" + 
			"        sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        detail.ex_int1 = sp_id\n" + 
			") ELSE CASE WHEN detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_spcake_sup.sp_hsncd\n" + 
			"    FROM\n" + 
			"        m_spcake_sup\n" + 
			"    WHERE\n" + 
			"        detail.item_id = m_spcake_sup.sp_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item_sup.item_hsncd\n" + 
			"    FROM\n" + 
			"        m_item_sup\n" + 
			"    WHERE\n" + 
			"        m_item_sup.item_id = detail.item_id\n" + 
			")\n" + 
			"END\n" + 
			"END AS item_hsncd,\n" + 
			"CASE WHEN detail.ex_int1 > 0 THEN(\n" + 
			"    SELECT\n" + 
			"        sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_category_sup\n" + 
			"    WHERE\n" + 
			"        detail.ex_int1 = sp_id\n" + 
			") ELSE CASE WHEN detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_spcake_sup.sp_uom\n" + 
			"    FROM\n" + 
			"        m_spcake_sup\n" + 
			"    WHERE\n" + 
			"        detail.item_id = m_spcake_sup.sp_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item_sup.item_uom\n" + 
			"    FROM\n" + 
			"        m_item_sup\n" + 
			"    WHERE\n" + 
			"        m_item_sup.item_id = detail.item_id\n" + 
			")\n" + 
			"END\n" + 
			"END AS item_uom\n" + 
			"FROM\n" + 
			"    t_credit_note_details detail\n" + 
			"WHERE\n" + 
			"    detail.crn_id IN(:crnId) ", nativeQuery = true)

	List<GetCrnDetails> getCrnDetailsById(@Param("crnId") List<String> crnId);

}
