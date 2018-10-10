package com.ats.webapi.repository.prodapp.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.MisrtrywiseFrItemReport;

public interface MisrtrywiseFrItemReportRepo extends JpaRepository<MisrtrywiseFrItemReport, Integer> {
	
	@Query(value = "SELECT t_sp_cake_sup.t_sp_cake_sup_noas ord_id,m_franchisee.fr_name,m_franchisee.fr_code,m_emp.emp_name,\n" + 
			"m_sp_cake.sp_code as item_code,m_sp_cake.sp_name as item_name,t_sp_cake_sup.input_kg_fr,t_sp_cake_sup.input_kg_prod,\n" + 
			"(t_sp_cake_sup.input_kg_prod-t_sp_cake_sup.input_kg_fr) as weight_diff,t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp"
			+ " FROM t_sp_cake_sup,m_franchisee,m_sp_cake,m_emp\n" + 
			"WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n" + 
			"AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id AND t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.mistry_id IN (:mistryIdList)" + 
			"  ", nativeQuery = true)
	List<MisrtrywiseFrItemReport> getMisrtrywiseFrItemReportSpSpecMis(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("mistryIdList") List<Integer> mistryIdList);
	
	@Query(value = "SELECT t_sp_cake_sup.t_sp_cake_sup_noas ord_id,m_franchisee.fr_name,m_franchisee.fr_code,m_emp.emp_name,\n" + 
			"m_sp_cake.sp_code as item_code,m_sp_cake.sp_name as item_name,t_sp_cake_sup.input_kg_fr,t_sp_cake_sup.input_kg_prod,\n" + 
			"(t_sp_cake_sup.input_kg_prod-t_sp_cake_sup.input_kg_fr) as weight_diff,t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp"
			+ " FROM t_sp_cake_sup,m_franchisee,m_sp_cake,m_emp\n" + 
			"WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.fr_id=m_franchisee.fr_id\n" + 
			"AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id AND t_sp_cake_sup.mistry_id=m_emp.emp_id" + 
			"  ", nativeQuery = true)
	List<MisrtrywiseFrItemReport> getMisrtrywiseFrItemReportSpAllMis(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	
	@Query(value = "SELECT t_reg_sp_cake_sup.sup_id as ord_id,m_franchisee.fr_name,m_franchisee.fr_code,m_emp.emp_name, "
			+ "m_item.item_id as item_code ,m_item.item_name,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.input_kg_prod "
			+ "as input_kg_fr,(t_reg_sp_cake_sup.input_kg_prod-t_reg_sp_cake_sup.input_kg_prod) as weight_diff, "
			+ "t_reg_sp_cake_sup.start_time as start_time_stamp,t_reg_sp_cake_sup.end_time  as end_time_stamp "
			+ "FROM t_reg_sp_cake_sup,m_franchisee,m_item,m_emp WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate "
			+ " AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.item_id=m_item.id AND "
			+ "t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND t_reg_sp_cake_sup.mistry_id IN (:mistryIdList) " + 
			"  ", nativeQuery = true)
	List<MisrtrywiseFrItemReport> getMisrtrywiseFrItemReportRegSpSpecMis(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("mistryIdList") List<Integer> mistryIdList);
	
	
	@Query(value = "SELECT t_reg_sp_cake_sup.sup_id as ord_id,m_franchisee.fr_name,m_franchisee.fr_code,m_emp.emp_name, "
			+ "m_item.item_id as item_code ,m_item.item_name,t_reg_sp_cake_sup.input_kg_prod,t_reg_sp_cake_sup.input_kg_prod "
			+ "as input_kg_fr,(t_reg_sp_cake_sup.input_kg_prod-t_reg_sp_cake_sup.input_kg_prod) as weight_diff, "
			+ "t_reg_sp_cake_sup.start_time as start_time_stamp,t_reg_sp_cake_sup.end_time  as end_time_stamp "
			+ "FROM t_reg_sp_cake_sup,m_franchisee,m_item,m_emp WHERE t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate "
			+ " AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_reg_sp_cake_sup.item_id=m_item.id AND "
			+ "t_reg_sp_cake_sup.mistry_id=m_emp.emp_id " + 
			"  ", nativeQuery = true)
	List<MisrtrywiseFrItemReport> getMisrtrywiseFrItemReportRegSpAllMis(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	

}
