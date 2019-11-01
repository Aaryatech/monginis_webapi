package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemWiseGrnGvnReport;

public interface ItemWiseGrnGvnReportRepo extends JpaRepository<ItemWiseGrnGvnReport, Integer>{
	
	@Query(value="select  g.item_id,m.item_name,sum(g.apr_qty_acc) as apr_qty_acc,sum(g.grn_gvn_qty) as grn_gvn_qty,sum(g.apr_taxable_amt) as apr_taxable_amt,"
			+ "sum(g.apr_total_tax) as apr_total_tax,sum(g.apr_grand_total) as apr_grand_total from t_grn_gvn g,m_item m where g.grn_gvn_date between :fromDate "
			+ "and :toDate and m.id=g.item_id and g.is_grn in (:isGrn) group by g.item_id order by m.item_grp1,m.item_grp2, m.item_name",nativeQuery=true)
	 List<ItemWiseGrnGvnReport> itemwiseGrnGvnReportbetweenDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("isGrn") List<Integer> isGrn);

}
