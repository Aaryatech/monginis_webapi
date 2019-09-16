package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.spprod.GetSpAdvanceReport;

public interface GetSpAdvanceRepo extends JpaRepository<GetSpAdvanceReport, Integer> {
	
	/*@Query(value="SELECT tsp.sp_cust_name as cust_name,msp.sp_name as item_name,tsp.order_date "
			+ "as order_date, " + 
			"tsp.sp_grand_total as total_mrp,tsp.sp_advance as adv_amt,tsp.sp_order_no ,"
			+ "tsp.sp_selected_weight as weight, tsp.sp_delivery_date as del_date " + 
			" FROM m_sp_cake msp,t_sp_cake tsp where  tsp.sp_id=msp.sp_id AND tsp.order_date "
			+ "BETWEEN :fromDate AND :toDate AND tsp.fr_id=:frId AND tsp.del_status=0 "
			,nativeQuery=true)
	List<GetSpAdvanceReport> getSpAdvance(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

*/
	
	//Anmol--------16-09-2019
	@Query(value="SELECT\n" + 
			"    tsp.sp_cust_name AS cust_name,\n" + 
			"    CASE WHEN tsp.menu_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        menu_id\n" + 
			"    FROM\n" + 
			"        m_fr_menu_show\n" + 
			"    WHERE\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\n" + 
			") THEN(\n" + 
			"    SELECT\n" + 
			"        sp_name\n" + 
			"    FROM\n" + 
			"        m_sp_cake\n" + 
			"    WHERE\n" + 
			"        sp_id = tsp.sp_id\n" + 
			") ELSE SUBSTRING_INDEX(item_id, '#', -1)\n" + 
			"END AS item_name,\n" + 
			"tsp.order_date AS order_date,\n" + 
			"tsp.sp_grand_total AS total_mrp,\n" + 
			"tsp.sp_advance AS adv_amt,\n" + 
			"tsp.sp_order_no,\n" + 
			"tsp.sp_selected_weight AS weight,\n" + 
			"tsp.sp_delivery_date AS del_date\n" + 
			"FROM\n" + 
			"    t_sp_cake tsp\n" + 
			"WHERE\n" + 
			"    tsp.order_date BETWEEN :fromDate AND :toDate AND tsp.fr_id = :frId AND tsp.del_status = 0 "
			,nativeQuery=true)
	List<GetSpAdvanceReport> getSpAdvance(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

	
}
