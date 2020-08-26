package com.ats.webapi.repository.ggreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.grngvnreport.GGDetailApr;

@Service
public interface GGDetailAprRepo extends JpaRepository<GGDetailApr, Integer>{

	
	/*
	 * @Query(
	 * value=" SELECT t_grn_gvn.grn_gvn_id,t_grn_gvn.bill_no,t_grn_gvn.fr_id, " +
	 * "t_grn_gvn.item_id,t_grn_gvn.grn_gvn_qty,t_grn_gvn.apr_qty_acc, t_grn_gvn.is_grn,"
	 * +
	 * "date(t_grn_gvn.approved_datetime_gate) as apr_date_gate,date(t_grn_gvn.approved_datetime_store)as apr_date_store,date(t_grn_gvn.approved_datetime_acc) as apr_date_acc, "
	 * + " " + "        CASE  " +
	 * "            WHEN t_grn_gvn.cat_id=5 THEN (SELECT " +
	 * "                m_sp_cake.sp_name  " + "            FROM " +
	 * "                m_sp_cake  " + "            WHERE " +
	 * "                m_sp_cake.sp_id=t_grn_gvn.item_id)    " +
	 * "            ELSE (SELECT " + "                m_item.item_name  " +
	 * "            FROM " + "                m_item  " + "            WHERE " +
	 * "                t_grn_gvn.item_id=m_item.id)  " +
	 * "        END AS item_name, 	t_grn_gvn.grn_gvn_status as status," +
	 * " CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate, "
	 * +
	 * " CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store, "
	 * + " CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc, "
	 * + "  " +
	 * " COALESCE( (SELECT m_user.usr_name FROM m_user WHERE  t_grn_gvn.approved_login_gate=m_user.usr_id),'-') as gate, "
	 * +
	 * " COALESCE( (SELECT m_user.usr_name FROM m_user WHERE  t_grn_gvn.approved_login_store=m_user.usr_id),'-') as store, "
	 * +
	 * "  COALESCE( (SELECT m_user.usr_name FROM m_user WHERE  t_grn_gvn.approved_login_acc=m_user.usr_id),'-') as acc "
	 * + " " + " FROM t_grn_gvn WHERE " +
	 * " t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId ",nativeQuery=true)
	 * 
	 * List<GGDetailApr> getGGDetailForAprReport(@Param("grnGvnHeaderId") int
	 * grnGvnHeaderId);
	 */
	
	
	@Query(value=" SELECT a.*, \n" + 
			"\n" + 
			" CASE WHEN a.cat_id=5 THEN (  sp.item_name )      \n" + 
			"			            ELSE ( item.item_name )    \n" + 
			"			        END AS item_name,\n" + 
			"                    \n" + 
			"                     COALESCE( (SELECT  gate_user.usr_name   ),'-') as gate,   \n" + 
			"                     COALESCE( (SELECT  store_user.usr_name   ),'-') as store,   \n" + 
			"                     COALESCE( (SELECT  acc_user.usr_name ),'-') as acc   \n" + 
			"		              \n" + 
			"from (SELECT t_grn_gvn.grn_gvn_id,t_grn_gvn.bill_no,t_grn_gvn.fr_id, t_grn_gvn.cat_id,   \n" + 
			"			t_grn_gvn.item_id,t_grn_gvn.grn_gvn_qty,t_grn_gvn.apr_qty_acc, t_grn_gvn.is_grn,  \n" + 
			"			date(t_grn_gvn.approved_datetime_gate) as apr_date_gate,date(t_grn_gvn.approved_datetime_store)as apr_date_store,\n" + 
			"      date(t_grn_gvn.approved_datetime_acc) as apr_date_acc,   \n" + 
			"      \n" + 
			"			   t_grn_gvn.approved_login_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_login_acc,\n" + 
			"			        	t_grn_gvn.grn_gvn_status as status,  \n" + 
			"			 CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,   \n" + 
			"			 CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,   \n" + 
			"			 CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc\n" + 
			"			    \n" + 
			"			\n" + 
			"			   \n" + 
			"			 FROM t_grn_gvn WHERE   \n" + 
			"			 t_grn_gvn.grn_gvn_header_id=:grnGvnHeaderId ) a LEFT JOIN (SELECT m_sp_cake.sp_name as item_name ,m_sp_cake.sp_id  FROM m_sp_cake) sp ON a.item_id=sp.sp_id LEFT JOIN \n" + 
			"             (SELECT  m_item.item_name ,m_item.id FROM   m_item   ) item ON item.id=a.item_id\n" + 
			"             \n" + 
			"             LEFT JOIN \n" + 
			"             (SELECT  m_user.usr_name,m_user.usr_id FROM m_user   ) gate_user   ON gate_user.usr_id=a.approved_login_gate\n" + 
			"             \n" + 
			"               LEFT JOIN \n" + 
			"             (SELECT  m_user.usr_name,m_user.usr_id FROM m_user   ) store_user   ON store_user.usr_id=a.approved_login_store\n" + 
			"             \n" + 
			"                LEFT JOIN \n" + 
			"             (SELECT  m_user.usr_name,m_user.usr_id FROM m_user   ) acc_user   ON acc_user.usr_id=a.approved_login_acc \n" + 
			"	  ",nativeQuery=true)
	
		List<GGDetailApr> getGGDetailForAprReport(@Param("grnGvnHeaderId") 
		int grnGvnHeaderId);
	
	/*
	  SELECT a.*, 

 CASE WHEN a.cat_id=5 THEN (  sp.item_name )      
			            ELSE ( item.item_name )    
			        END AS item_name,
                    
                     COALESCE( (SELECT  gate_user.usr_name   ),'-') as gate,   
                     COALESCE( (SELECT  store_user.usr_name   ),'-') as store,   
                     COALESCE( (SELECT  acc_user.usr_name ),'-') as acc   
		              
from (SELECT t_grn_gvn.grn_gvn_id,t_grn_gvn.bill_no,t_grn_gvn.fr_id, t_grn_gvn.cat_id,   
			t_grn_gvn.item_id,t_grn_gvn.grn_gvn_qty,t_grn_gvn.apr_qty_acc, t_grn_gvn.is_grn,  
			date(t_grn_gvn.approved_datetime_gate) as apr_date_gate,date(t_grn_gvn.approved_datetime_store)as apr_date_store,
      date(t_grn_gvn.approved_datetime_acc) as apr_date_acc,   
      
			   t_grn_gvn.approved_login_gate,t_grn_gvn.approved_login_store,t_grn_gvn.approved_login_acc,
			        	t_grn_gvn.grn_gvn_status as status,  
			 CAST(t_grn_gvn.approved_datetime_gate AS CHAR) as approved_datetime_gate,   
			 CAST(t_grn_gvn.approved_datetime_store AS CHAR) as approved_datetime_store,   
			 CAST(t_grn_gvn.approved_datetime_acc AS CHAR) as approved_datetime_acc
			    
			
			   
			 FROM t_grn_gvn WHERE   
			 t_grn_gvn.grn_gvn_header_id=41425 ) a LEFT JOIN (SELECT m_sp_cake.sp_name as item_name ,m_sp_cake.sp_id  FROM m_sp_cake) sp ON a.item_id=sp.sp_id LEFT JOIN 
             (SELECT  m_item.item_name ,m_item.id FROM   m_item   ) item ON item.id=a.item_id
             
             LEFT JOIN 
             (SELECT  m_user.usr_name,m_user.usr_id FROM m_user   ) gate_user   ON gate_user.usr_id=a.approved_login_gate
             
               LEFT JOIN 
             (SELECT  m_user.usr_name,m_user.usr_id FROM m_user   ) store_user   ON store_user.usr_id=a.approved_login_store
             
                LEFT JOIN 
             (SELECT  m_user.usr_name,m_user.usr_id FROM m_user   ) acc_user   ON acc_user.usr_id=a.approved_login_acc 
	 */
}
