package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetBillDetails;

public interface GetBillDetailsRepository extends JpaRepository<GetBillDetails, Integer> {
	
	/*@Query(value="SELECT\n" + 
			"        t_bill_detail.* ,\n" + 
			"       CASE \n" + 
			"            WHEN t_bill_detail.cat_id=5 THEN (select m_sp_cake.sp_name FROM m_sp_cake \n" + 
			"WHERE t_bill_detail.item_id=m_sp_cake.sp_id)\n" + 
			"            ELSE (SELECT  m_item.item_name FROM m_item WHERE t_bill_detail.item_id=m_item.id )\n" + 
			"        END AS item_name,\n" + 
			"        m_category.cat_name,\n" + 
			"        t_bill_header.bill_date  \n" + 
			"    FROM\n" + 
			"        t_bill_detail,\n" + 
			"        m_category,\n" + 
			"        t_bill_header\n" + 
			"\n" + 
			"    WHERE\n" + 
			"        t_bill_detail.bill_no=:billNo"+
			"        AND m_category.cat_id=t_bill_detail.cat_id \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no",nativeQuery=true)
	
	List<GetBillDetails> showBillDetails(@Param("billNo") int billNo);*/
	
	
	
	@Query(value="SELECT\n" + 
			"    t_bill_detail.*,\n" + 
			"    CASE WHEN t_bill_detail.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND is_same_day_applicable = 4 AND cat_id = 5\n" + 
			") THEN CASE WHEN t_bill_detail.cat_id = 5 THEN(\n" + 
			"    SELECT\n" + 
			"        m_sp_cake.sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake\n" + 
			"    WHERE\n" + 
			"        t_bill_detail.item_id = m_sp_cake.sp_id\n" + 
			") ELSE(\n" + 
			"    SELECT\n" + 
			"        m_item.item_name\n" + 
			"    FROM\n" + 
			"        m_item\n" + 
			"    WHERE\n" + 
			"        t_bill_detail.item_id = m_item.id\n" + 
			")\n" + 
			"END ELSE(\n" + 
			"    SELECT\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', -1)\n" + 
			"    FROM\n" + 
			"        t_sp_cake\n" + 
			"    WHERE\n" + 
			"        t_sp_cake.sp_order_no = t_bill_detail.order_id AND t_bill_detail.cat_id = 5\n" + 
			")\n" + 
			"END AS item_name,\n" + 
			"m_category.cat_name,\n" + 
			"t_bill_header.bill_date\n" + 
			"FROM\n" + 
			"    t_bill_detail,\n" + 
			"    m_category,\n" + 
			"    t_bill_header\n" + 
			"WHERE\n" + 
			"    t_bill_detail.bill_no = :billNo AND m_category.cat_id = t_bill_detail.cat_id AND t_bill_detail.bill_no = t_bill_header.bill_no",nativeQuery=true)
	
	List<GetBillDetails> showBillDetails(@Param("billNo") int billNo);
	
	
	
	
	
	@Query(value="SELECT t_bill_detail.* ,m_item.item_name,m_category.cat_name,t_bill_header.bill_date "
			+ " FROM t_bill_detail,m_item,m_category,t_bill_header WHERE t_bill_detail.bill_no IN (:billNoList)  "
			+ "AND t_bill_detail.item_id=m_item.id AND m_category.cat_id=t_bill_detail.cat_id "
			+ "AND t_bill_detail.bill_no=t_bill_header.bill_no",nativeQuery=true)
	
	List<GetBillDetails> getBillDetailsForPrint(@Param("billNoList") List<String> billNoList);
	
	
}
