package com.ats.webapi.repository.bmsstock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.GetCurProdAndBillQty;

public interface GetCurProdAndBillQtyRepo extends JpaRepository<GetCurProdAndBillQty, Integer>{
	//Prev Query
	/*@Query(value=" SELECT m_item.id,m_item.item_name, \n" + 
			"coalesce((Select SUM(t_production_plan_detail.production_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate "
			+ "AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id "
			+ "AND m_item.id=t_production_plan_detail.item_id),0) AS prod_qty, \n" + 
			"\n" + 
			"coalesce((Select SUM(t_production_plan_detail.rejected_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate AND"
			+ " t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND"
			+ " m_item.id=t_production_plan_detail.item_id),0) AS rejected_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_bill_detail.bill_qty) FROM t_bill_header,t_bill_detail"
			+ " WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no "
			+ "AND m_item.id=t_bill_detail.item_id AND t_bill_detail.menu_id!=42 ),0) AS bill_qty,"
			
			+ "coalesce((Select SUM( t_stock_trasf_detail.qty) "
			+ "FROM t_stock_trasf_header,t_stock_trasf_detail\n" + 
			"WHERE t_stock_trasf_header.stock_date=:prodDate AND t_stock_trasf_header.stock_transf_header_id =t_stock_trasf_detail.stock_transf_header_id  "
			+ "AND m_item.id=t_stock_trasf_detail.item_id),0) \n" + 
			"AS damaged_qty  "
			+ "FROM m_item where m_item.item_grp1=:catId AND m_item.del_status=:delStatus "
				+ "",nativeQuery=true)*/
	@Query(value=" Select a.id,a.item_name,coalesce(b.prod_qty,0) as prod_qty,coalesce(b.rejected_qty,0) as rejected_qty,coalesce(c.bill_qty,0) as bill_qty,coalesce(d.damaged_qty,0) as damaged_qty\n" + 
			"from\n" + 
			" (SELECT m_item.id,m_item.item_name,item_grp1,item_grp2 	 FROM m_item where m_item.item_grp1=:catId AND m_item.del_status=:delStatus) a\n" + 
			" LEFT JOIN \n" + 
			" (Select t_production_plan_detail.item_id,SUM(t_production_plan_detail.production_qty) as prod_qty,SUM(t_production_plan_detail.rejected_qty) as rejected_qty FROM t_production_plan_detail,\n" + 
			"	t_production_plan_header where t_production_plan_header.production_date=:prodDate and t_production_plan_header.cat_id=:catId\n" + 
			"	AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id  group by t_production_plan_detail.item_id) b\n" + 
			"	ON a.id=b.item_id\n" + 
			"LEFT JOIN \n" + 
			" (\n" + 
			"Select t_bill_detail.item_id,SUM( t_bill_detail.bill_qty) as bill_qty FROM t_bill_header,t_bill_detail\n" + 
			"			  WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"			AND t_bill_detail.cat_id=:catId   and t_bill_detail.menu_id NOT IN (select menu_id from m_fr_menu_show where is_same_day_applicable=3) group by t_bill_detail.item_id\n" + 
			" ) c 	ON a.id=c.item_id\n" + 
			" LEFT JOIN \n" + 
			" (\n" + 
			" Select t_stock_trasf_detail.item_id, SUM(t_stock_trasf_detail.qty) as damaged_qty\n" + 
			"			 FROM t_stock_trasf_header,t_stock_trasf_detail  \n" + 
			"			WHERE t_stock_trasf_header.stock_date=:prodDate AND t_stock_trasf_detail.cat_id=:catId     and t_stock_trasf_header.stock_transf_header_id =t_stock_trasf_detail.stock_transf_header_id  \n" + 
			"			  group by t_stock_trasf_detail.item_id\n" + 
			") d ON a.id=d.item_id\n" + 
			"\n" + 
			"order by a.item_grp2,a.item_name\n" + 
			"\n" + 
			"",nativeQuery=true)
	List<GetCurProdAndBillQty> getCurProdAndBillQty(@Param("prodDate") String prodDate,@Param("catId") int catId,@Param("delStatus") int delStatus,
			@Param("timestamp") String timestamp,@Param("curTimeStamp") String curTimeStamp);

//New Query
	
	//changed for getting All Items without catIds 27 Jan 2018
	
	/*@Query(value=" SELECT m_item.id,m_item.item_name, \n" + 
			"coalesce((Select SUM(t_production_plan_detail.production_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate "
			+ "AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id "
			+ "AND m_item.id=t_production_plan_detail.item_id),0) AS prod_qty, \n" + 
			"\n" + 
			"coalesce((Select SUM(t_production_plan_detail.rejected_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate AND"
			+ " t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND"
			+ " m_item.id=t_production_plan_detail.item_id),0) AS rejected_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_bill_detail.bill_qty) FROM t_bill_header,t_bill_detail"
			+ " WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no "
			+ "AND m_item.id=t_bill_detail.item_id AND t_bill_detail.menu_id!=42),0) AS bill_qty,"
			
	+ "coalesce((Select SUM( t_stock_trasf_detail.qty) "
	+ "FROM t_stock_trasf_header,t_stock_trasf_detail\n" + 
	"WHERE t_stock_trasf_header.stock_date=:prodDate AND t_stock_trasf_header.stock_transf_header_id =t_stock_trasf_detail.stock_transf_header_id  "
	+ "AND m_item.id=t_stock_trasf_detail.item_id),0) \n" + 
	"AS damaged_qty  "
			+ "FROM m_item where m_item.del_status=:delStatus "
				+ "",nativeQuery=true)*/
	
	@Query(value="Select a.id,a.item_name,coalesce(b.prod_qty,0) as prod_qty,coalesce(b.rejected_qty,0) as rejected_qty,coalesce(c.bill_qty,0) as bill_qty,coalesce(d.damaged_qty,0) as damaged_qty\n" + 
			"from\n" + 
			" (SELECT m_item.id,m_item.item_name,item_grp1,item_grp2 	 FROM m_item where  m_item.del_status=:delStatus) a\n" + 
			" LEFT JOIN \n" + 
			" (Select t_production_plan_detail.item_id,SUM(t_production_plan_detail.production_qty) as prod_qty,SUM(t_production_plan_detail.rejected_qty) as rejected_qty FROM t_production_plan_detail,\n" + 
			"	t_production_plan_header where t_production_plan_header.production_date=:prodDate\n" + 
			"	AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id  group by t_production_plan_detail.item_id) b\n" + 
			"	ON a.id=b.item_id\n" + 
			"LEFT JOIN \n" + 
			" (\n" + 
			"Select t_bill_detail.item_id,SUM( t_bill_detail.bill_qty) as bill_qty FROM t_bill_header,t_bill_detail\n" + 
			"			  WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"		and t_bill_detail.menu_id NOT IN (select menu_id from m_fr_menu_show where is_same_day_applicable=3) group by t_bill_detail.item_id\n" + 
			" ) c 	ON a.id=c.item_id\n" + 
			" LEFT JOIN \n" + 
			" (\n" + 
			" Select t_stock_trasf_detail.item_id, SUM(t_stock_trasf_detail.qty) as damaged_qty\n" + 
			"			 FROM t_stock_trasf_header,t_stock_trasf_detail  \n" + 
			"			WHERE t_stock_trasf_header.stock_date=:prodDate    and t_stock_trasf_header.stock_transf_header_id =t_stock_trasf_detail.stock_transf_header_id  \n" + 
			"			  group by t_stock_trasf_detail.item_id\n" + 
			") d ON a.id=d.item_id\n" + 
			"\n" + 
			"order by a.item_grp2,a.item_name",nativeQuery=true)
	List<GetCurProdAndBillQty> getCurProdAndBillQtyAllCat(@Param("prodDate") String prodDate,@Param("delStatus") int delStatus,
		@Param("timestamp") String timestamp,@Param("curTimeStamp") String curTimeStamp);

	
}
