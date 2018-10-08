package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.GetDataForGateSaleDayEnd;

public interface GetDataForGateSaleDayEndRepo extends JpaRepository<GetDataForGateSaleDayEnd, Integer> {

	@Query(value = " SELECT m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_name,m_category.cat_id,"
			+ " COALESCE((SELECT  SUM(t_stock_trasf_detail.apr_qty1)  FROM t_stock_trasf_detail,t_stock_trasf_header "
			+ " WHERE t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND t_stock_trasf_header.type=:stockType and"
			+ ""
			+ " t_stock_trasf_header.stock_date=:date AND t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id "
			+ " GROUP BY t_stock_trasf_detail.sub_cat_id ),0) AS in_qty,"
			+ " COALESCE((SELECT SUM(t_gatesale_bill_detail.item_qty) FROM t_gatesale_bill_detail,t_gatesale_bill_header,"
			+ " m_item WHERE t_gatesale_bill_detail.item_id=m_item.id AND t_gatesale_bill_detail.bill_id=t_gatesale_bill_header.bill_id "
			+ " AND t_gatesale_bill_header.bill_date=:date  AND  m_cat_sub.sub_cat_id=m_item.item_grp2 GROUP BY m_item.item_grp2),0) "
			+ " AS sale_qty "
			+ " FROM m_cat_sub,m_category WHERE  m_cat_sub.del_status=0 AND m_cat_sub.cat_id=m_category.cat_id ", nativeQuery = true)

	List<GetDataForGateSaleDayEnd> getInQtyAndSaleQtySubCatwise(@Param("date") String date,@Param("stockType")int stockType);

}
