package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.TSellReport; 

public interface TSellReportRepository extends JpaRepository<TSellReport, Integer>{
	
	@Query(value="select d.item_id, i.item_name, s.item_hsncd as hsn_no, sum(d.cgst_rs) as cgst, sum(d.sgst_rs) as sgst, "
			+ "sum(d.igst_rs) as igst, sum(d.total_tax) as total_tax, sum(d.taxable_amt) as taxable_amt, "
			+ "sum(d.grand_total) as grand_total from t_sell_bill_detail d , m_item i, t_sell_bill_header h, m_item_sup s "
			+ "where h.bill_date between :fromDate and :toDate and d.sell_bill_no=h.sell_bill_no and d.item_id=i.id "
			+ "and d.item_id=s.item_id and h.fr_id=:frId group by d.item_id",nativeQuery=true)
	List<TSellReport> hsnCodeWiseReport( @Param("frId")int frId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);

}
