package com.ats.webapi.repository.prodapp.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.MistrywiseReport;

//report no 3 and 4  on both table
public interface MistrywiseReportRepo  extends JpaRepository<MistrywiseReport, Integer>{
	
	//sp 3.1
	@Query(value = "SELECT t_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_sp_cake_sup.t_sp_cake_sup_no) "
			+ " AS no_of_cakes,SUM(t_sp_cake_sup.ex_var) AS time_required "
			+ " FROM t_sp_cake_sup,m_emp WHERE t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.date "
			+ " BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.mistry_id IN (:mistryIdList) GROUP BY t_sp_cake_sup.mistry_id \n" + 
			" " + 
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportSpSpecMistry(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("mistryIdList") List<Integer> mistryIdList);
	//sp 3.2
	@Query(value = "SELECT t_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_sp_cake_sup.t_sp_cake_sup_no) "
			+ " AS no_of_cakes,SUM(t_sp_cake_sup.ex_var) AS time_required "
			+ " FROM t_sp_cake_sup,m_emp WHERE t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.date "
			+ " BETWEEN :fromDate AND :toDate GROUP BY t_sp_cake_sup.mistry_id \n" + 
			" " + 
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportSpAllMistry(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	//
	//reg sp 3.1
	@Query(value = " SELECT t_reg_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_reg_sp_cake_sup.sup_id) "
			+ " AS no_of_cakes,SUM(t_reg_sp_cake_sup.ex_char) AS time_required FROM "
			+ " t_reg_sp_cake_sup,m_emp WHERE t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND "
			+ " t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate  "
			+ " AND t_reg_sp_cake_sup.mistry_id IN (:mistryIdList) GROUP BY t_reg_sp_cake_sup.mistry_id " + 
		
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportRegSpSpecMistry(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("mistryIdList") List<Integer> mistryIdList);

	//reg sp 3.2
	@Query(value = " SELECT t_reg_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_reg_sp_cake_sup.sup_id) " + 
			" AS no_of_cakes,SUM(t_reg_sp_cake_sup.ex_char) AS time_required FROM " + 
			" t_reg_sp_cake_sup,m_emp WHERE t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND " + 
			" t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate " + 
			" GROUP BY t_reg_sp_cake_sup.mistry_id  " + 
			" " + 
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportRegSpAllMistry(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
	
	 //sp 4.1
	@Query(value = "SELECT t_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_sp_cake_sup.t_sp_cake_sup_no) "
			+ " AS no_of_cakes,SUM(t_sp_cake_sup.ex_var) AS time_required "
			+ " FROM t_sp_cake_sup,m_emp WHERE t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.date "
			+ " BETWEEN :fromDate AND :toDate AND t_sp_cake_sup.mistry_id IN (:mistryIdList) GROUP BY t_sp_cake_sup.date \n" + 
			" " + 
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportSpSpecMistryGrpDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("mistryIdList") List<Integer> mistryIdList);
	//sp 4.2
	@Query(value = "SELECT t_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_sp_cake_sup.t_sp_cake_sup_no) "
			+ " AS no_of_cakes,SUM(t_sp_cake_sup.ex_var) AS time_required "
			+ " FROM t_sp_cake_sup,m_emp WHERE t_sp_cake_sup.mistry_id=m_emp.emp_id AND t_sp_cake_sup.date "
			+ " BETWEEN :fromDate AND :toDate GROUP BY t_sp_cake_sup.date \n" + 
			" " + 
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportSpAllMistryGrpDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	//
	//reg sp 4.1
	@Query(value = " SELECT t_reg_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_reg_sp_cake_sup.sup_id) "
			+ " AS no_of_cakes,SUM(t_reg_sp_cake_sup.ex_char) AS time_required FROM "
			+ " t_reg_sp_cake_sup,m_emp WHERE t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND "
			+ " t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate  "
			+ " AND t_reg_sp_cake_sup.mistry_id IN (:mistryIdList) GROUP BY t_reg_sp_cake_sup.prod_date " + 
		
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportRegSpSpecMistryGrpDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("mistryIdList") List<Integer> mistryIdList);

	//reg sp 4.2
	@Query(value = " SELECT t_reg_sp_cake_sup.mistry_id,m_emp.emp_name,COUNT(t_reg_sp_cake_sup.sup_id) " + 
			" AS no_of_cakes,SUM(t_reg_sp_cake_sup.ex_char) AS time_required FROM " + 
			" t_reg_sp_cake_sup,m_emp WHERE t_reg_sp_cake_sup.mistry_id=m_emp.emp_id AND " + 
			" t_reg_sp_cake_sup.prod_date BETWEEN :fromDate AND :toDate " + 
			" GROUP BY t_reg_sp_cake_sup.prod_date  " + 
			" " + 
			"  ", nativeQuery = true)
	List<MistrywiseReport> getMistrywiseReportRegSpAllMistryGrpDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	
}
