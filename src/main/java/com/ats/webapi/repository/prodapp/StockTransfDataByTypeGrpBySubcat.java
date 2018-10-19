package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.StockTransfDataByTypeGrpBySubC;

public interface StockTransfDataByTypeGrpBySubcat extends JpaRepository<StockTransfDataByTypeGrpBySubC, Integer> {

	@Query(value = "SELECT m_cat_sub.sub_cat_id,m_cat_sub.sub_cat_name,m_category.cat_id,m_category.cat_name,\n" + 
			
			"COALESCE((SELECT SUM(t_stock_trasf_detail.qty) FROM t_stock_trasf_detail,t_stock_trasf_header,stock_transf_type WHERE t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND\n" + 
			"t_stock_trasf_header.stock_date BETWEEN :fromDate AND :toDate AND\n" + 
			"t_stock_trasf_header.type=stock_transf_type.stock_transf_type_id AND\n" + 
			"stock_transf_type.stock_transf_type_id IN (:typeIdList) AND t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id),0) AS qty,\n" + 
		
			"COALESCE((SELECT SUM(t_stock_trasf_detail.apr_qty1) FROM t_stock_trasf_detail,t_stock_trasf_header,stock_transf_type\n" + 
			"WHERE t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND\n" + 
			"t_stock_trasf_header.stock_date BETWEEN :fromDate AND :toDate AND\n" + 
			"t_stock_trasf_header.type=stock_transf_type.stock_transf_type_id AND\n" + 
			"stock_transf_type.stock_transf_type_id IN (:typeIdList) AND t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id),0) AS apr_qty1,\n" + 
		
			"COALESCE((SELECT SUM(t_stock_trasf_detail.apr_qty2) FROM t_stock_trasf_detail,t_stock_trasf_header,stock_transf_type\n" + 
			"WHERE t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND\n" + 
			"t_stock_trasf_header.stock_date BETWEEN :fromDate AND :toDate AND\n" + 
			"t_stock_trasf_header.type=stock_transf_type.stock_transf_type_id AND\n" + 
			"stock_transf_type.stock_transf_type_id IN (:typeIdList) AND t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id),0) AS apr_qty2,\n" + 
			"                     \n" + 
			"COALESCE((SELECT SUM(t_stock_trasf_detail.apr_qty3) FROM t_stock_trasf_detail,t_stock_trasf_header,stock_transf_type\n" + 
			"WHERE t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND\n" + 
			"t_stock_trasf_header.stock_date BETWEEN :fromDate AND :toDate AND\n" + 
			"t_stock_trasf_header.type=stock_transf_type.stock_transf_type_id AND\n" + 
			"stock_transf_type.stock_transf_type_id IN (:typeIdList) AND t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id),0) AS apr_qty3\n" + 
			"         \n" + 
			"         FROM m_cat_sub,m_category WHERE m_cat_sub.cat_id=m_category.cat_id\n" + 
			"         AND m_cat_sub.del_status=0", nativeQuery = true)

	List<StockTransfDataByTypeGrpBySubC> getStockTransfDataByTypeGrpByItem(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeIdList") List<Integer> typeIdList);

}
