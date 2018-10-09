package com.ats.webapi.repository.prodapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prodapp.FrwiseStockTransfData;

public interface FrwiseStockTransfDataRepo extends JpaRepository<FrwiseStockTransfData, Integer> {

	@Query(value = " SELECT t_stock_trasf_detail.item_id,t_stock_trasf_detail.sub_cat_id,"
			+ "	SUM(t_stock_trasf_detail.qty) ,SUM(t_stock_trasf_detail.price),"
			+ "	m_item.item_name,m_cat_sub.sub_cat_name "
			+ "	 FROM t_stock_trasf_detail,t_stock_trasf_header,m_item,m_cat_sub,stock_transf_type "
			+ "	 WHERE t_stock_trasf_header.stock_date BETWEEN :fromDate AND :toDate AND "
			+ "	t_stock_trasf_header.type=stock_transf_type.stock_transf_type_id AND t_stock_trasf_header.fr_id IN (:frIdList) AND "
			+ "	stock_transf_type.stock_transf_type_id IN (:stockTypeList) AND "
			+ "	t_stock_trasf_detail.stock_transf_header_id=t_stock_trasf_header.stock_transf_header_id AND "
			+ "	m_item.id=t_stock_trasf_detail.item_id AND   t_stock_trasf_detail.sub_cat_id=m_cat_sub.sub_cat_id AND "
			+ "	t_stock_trasf_detail.menu_id  IN (:menuIdList) "
			+ "	GROUP BY t_stock_trasf_detail.item_id ", nativeQuery = true)

	
	List<FrwiseStockTransfData> getFrwiseStockTransfData(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("stockTypeList") List<Integer> stockTypeList, @Param("menuIdList") List<Integer> menuIdList,
			@Param("frIdList") List<Integer> frIdList);

}
