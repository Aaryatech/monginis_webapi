package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.StockTransfDataByTypeGrpByItem;

public interface StockTransfDataByTypeGrpByItemRepo extends JpaRepository<StockTransfDataByTypeGrpByItem, Integer> {

	@Query(value = " SELECT t_stock_trasf_detail.item_id,"
			+ "t_stock_trasf_detail.cat_id,t_stock_trasf_detail.sub_cat_id,t_stock_trasf_detail.menu_id,"
			+ "SUM(t_stock_trasf_detail.qty) AS qty,SUM(t_stock_trasf_detail.apr_qty1) AS apr_qty1,"
			+ "SUM(t_stock_trasf_detail.apr_qty2) AS apr_qty2,SUM(t_stock_trasf_detail.apr_qty3) AS apr_qty3,"
			+ "m_item.item_name,m_cat_sub.sub_cat_name,m_category.cat_name"
			+ "FROM t_stock_trasf_detail,t_stock_trasf_header,m_item,m_cat_sub,m_category,stock_transf_type"
			+ "WHERE t_stock_trasf_header.stock_date BETWEEN :fromDate AND :toDate AND "
			+ "t_stock_trasf_header.type=stock_transf_type.stock_transf_type_id AND"
			+ "stock_transf_type.stock_transf_type_id IN (:typeIdList) AND"
			+ "t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND"
			+ "m_item.id=t_stock_trasf_detail.item_id AND " + "t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id AND"
			+ "t_stock_trasf_detail.cat_id=m_category.cat_id"
			+ "GROUP BY t_stock_trasf_detail.item_id ", nativeQuery = true)

	List<StockTransfDataByTypeGrpByItem> getStockTransfDataByTypeGrpByItem(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeIdList") List<Integer> typeIdList);

}
