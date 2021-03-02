package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetNonRegFr;

@Repository
public interface GetNonRegFrRepo extends JpaRepository<GetNonRegFr, Integer>{

	@Query(value="SELECT m_franchisee.fr_id,m_franchisee.fr_name,m_franchisee.fr_code,ROUND(SUM(t_bill_header.taxable_amt),2) AS taxable_amt,ROUND(SUM(t_bill_header.total_tax),2) AS total_tax,round (sum(t_bill_header.grand_total),2) AS grand_total FROM m_franchisee INNER JOIN t_bill_header ON  m_franchisee.fr_id=t_bill_header.fr_id AND m_franchisee.fr_gst_type=0 AND m_franchisee.del_status=0 and t_bill_header.bill_date BETWEEN :fromDate and :toDate GROUP BY t_bill_header.fr_id",nativeQuery=true)
	List<GetNonRegFr> getNonRegFrReports(@Param("fromDate")String fromDate,@Param("toDate")String toDate);
	
}
