package com.ats.webapi.repository.ggreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.grngvnreport.GGDetailApr;

@Service
public interface GGDetailAprRepo extends JpaRepository<GGDetailApr, Integer>{

	
	@Query(value=" SELECT t_grn_gvn.grn_gvn_id,t_grn_gvn.bill_no,t_grn_gvn.fr_id, " + 
			"t_grn_gvn.item_id,t_grn_gvn.grn_gvn_qty,t_grn_gvn.apr_qty_acc, t_grn_gvn.is_grn," + 
			"date(t_grn_gvn.approved_datetime_gate) as apr_date_gate,date(t_grn_gvn.approved_datetime_store)as apr_date_store,date(t_grn_gvn.approved_datetime_acc) as apr_date_acc, " + 
			" " + 
			"        CASE  " + 
			"            WHEN t_grn_gvn.cat_id=5 THEN (SELECT " + 
			"                m_sp_cake.sp_name  " + 
			"            FROM " + 
			"                m_sp_cake  " + 
			"            WHERE " + 
			"                m_sp_cake.sp_id=t_grn_gvn.item_id)    " + 
			"            ELSE (SELECT " + 
			"                m_item.item_name  " + 
			"            FROM " + 
			"                m_item  " + 
			"            WHERE " + 
			"                t_grn_gvn.item_id=m_item.id)  " + 
			"        END AS item_name, 	t_grn_gvn.grn_gvn_status as status," + 
			" CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate, " + 
			" CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store, " + 
			" CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc, " + 
			"  " + 
			" COALESCE( (SELECT m_user.usr_name FROM m_user WHERE  t_grn_gvn.approved_login_gate=m_user.usr_id),'-') as gate, " + 
			" COALESCE( (SELECT m_user.usr_name FROM m_user WHERE  t_grn_gvn.approved_login_store=m_user.usr_id),'-') as store, " + 
			"  COALESCE( (SELECT m_user.usr_name FROM m_user WHERE  t_grn_gvn.approved_login_acc=m_user.usr_id),'-') as acc " + 
			" " + 
			" FROM t_grn_gvn WHERE " + 
			" t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId ",nativeQuery=true)
	
		List<GGDetailApr> getGGDetailForAprReport(@Param("grnGvnHeaderId") 
		int grnGvnHeaderId);
	
	
}
