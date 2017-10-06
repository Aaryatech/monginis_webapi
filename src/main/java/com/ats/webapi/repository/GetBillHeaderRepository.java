package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetBillHeader;

public interface GetBillHeaderRepository extends JpaRepository<GetBillHeader, Integer> {
	
	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ ",t_bill_header.fr_id,t_bill_header.fr_code,"
			+ " t_bill_header.tax_applicable,t_bill_header.total,t_bill_header.total_without_tax, "
			+ " t_bill_header.total_tax,t_bill_header.status,t_bill_header.remark,t_bill_header.del_status, "
			+ " m_franchisee.fr_name FROM t_bill_header,m_franchisee WHERE t_bill_header.fr_id IN (:frId) "
			+ " AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate "
			+ " AND t_bill_header.fr_id=m_franchisee.fr_id " + 
			"",nativeQuery=true)
	
	List<GetBillHeader> getBillHeader(@Param("frId") List<String> frId,@Param("fromDate")String fromDate, @Param("toDate")String toDate);

	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ ",t_bill_header.fr_id,t_bill_header.fr_code,"
			+ " t_bill_header.tax_applicable,t_bill_header.total,t_bill_header.total_without_tax, "
			+ " t_bill_header.total_tax,t_bill_header.status,t_bill_header.remark,t_bill_header.del_status, "
			+ " m_franchisee.fr_name FROM t_bill_header,m_franchisee WHERE "
			+ " t_bill_header.bill_date BETWEEN :fromDate AND :toDate "
			+ " AND t_bill_header.fr_id=m_franchisee.fr_id " + 
			"",nativeQuery=true)
	
	List<GetBillHeader> getBillHeaderForAllFr(@Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
}
