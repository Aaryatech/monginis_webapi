package com.ats.webapi.repository.prodapp.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.FrwiseRateChangedItemReport;
//report 6 
public interface FrwiseRateChangedItemReportRepo extends JpaRepository<FrwiseRateChangedItemReport, Integer> {

	@Query(value = "SELECT t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,"
			+ "t_sp_cake_sup.date as prod_date, m_sp_cake.sp_code,m_sp_cake.sp_name FROM t_sp_cake_sup,"
			+ "m_franchisee,m_sp_cake WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate "
			+ "AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND t_sp_cake_sup.fr_id IN (:frIdList) "
			+ "AND t_sp_cake_sup.ex_int=1 AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id " + "  ", nativeQuery = true)

	List<FrwiseRateChangedItemReport> getFrwiseRateChangedItemReportSpecFr(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("frIdList") List<Integer> frIdList);

	@Query(value = "SELECT t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,"
			+ "t_sp_cake_sup.date as prod_date, m_sp_cake.sp_code,m_sp_cake.sp_name FROM t_sp_cake_sup,"
			+ "m_franchisee,m_sp_cake WHERE t_sp_cake_sup.date BETWEEN :fromDate AND :toDate "
			+ "AND t_sp_cake_sup.fr_id=m_franchisee.fr_id "
			+ "AND t_sp_cake_sup.ex_int=1 AND t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id " + "  ", nativeQuery = true)

	List<FrwiseRateChangedItemReport> getFrwiseRateChangedItemReportAllFr(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
