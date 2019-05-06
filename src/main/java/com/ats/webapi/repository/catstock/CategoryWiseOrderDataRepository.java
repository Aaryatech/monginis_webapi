package com.ats.webapi.repository.catstock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.catstock.CategoryWiseOrderData;
@Repository
public interface CategoryWiseOrderDataRepository extends JpaRepository<CategoryWiseOrderData, Integer>{

	@Query(value="select t_bill_detail.bill_detail_no,\n" + 
			"m_cat_sub.sub_cat_id,\n" + 
			"t_bill_header.fr_id,\n" + 
			"m_franchisee.fr_name,\n" + 
			"t_bill_detail.item_id,\n" + 
			"m_item.item_name,\n" + 
			"SUM(t_bill_detail.order_qty) as order_qty,\n" + 
			"SUM(t_bill_detail.bill_qty) as bill_qty,\n" + 
			"\n" + 
			"coalesce((SELECT sum(t_grn_gvn.apr_qty_acc) as apr_qty  from t_grn_gvn_header,t_grn_gvn, m_franchisee,m_cat_sub s,m_item i\n" + 
			"		 WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and  t_grn_gvn.item_id=i.id  and i.item_grp2=s.sub_cat_id  and t_grn_gvn_header.fr_id IN (t_bill_header.fr_id) and i.item_grp2 IN(m_cat_sub.sub_cat_id) \n" + 
			"		 AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id \n" + 
			"		 ),0) as grn_qty\n" + 
			"\n" + 
			"from t_bill_detail,t_bill_header,m_franchisee,m_item,m_cat_sub\n" + 
			"where t_bill_detail.bill_no In(select bill_no from t_bill_header\n" + 
			"where bill_date between :fromDate  and :toDate and fr_id in(:frId)) And m_item.item_grp2 In(:subCatList) \n" + 
			"And t_bill_header.fr_id=m_franchisee.fr_id and t_bill_header.del_status=0 \n" + 
			"And m_item.id=t_bill_detail.item_id And m_cat_sub.sub_cat_id=m_item.item_grp2 And t_bill_header.bill_no=t_bill_detail.bill_no\n" + 
			"group by t_bill_header.fr_id,m_item.item_grp2 order by t_bill_header.fr_id,m_item.item_grp2",nativeQuery=true)
	List<CategoryWiseOrderData> getSubCatStockReport(@Param("fromDate")String fromDateYMD,@Param("toDate") String toDateYMD,@Param("frId") List<String> frId,
			@Param("subCatList")List<String> subCatList);

	@Query(value="select t_bill_detail.bill_detail_no,\n" + 
			"m_cat_sub.sub_cat_id,\n" + 
			"t_bill_header.fr_id,\n" + 
			"m_franchisee.fr_name,\n" + 
			"t_bill_detail.item_id,\n" + 
			"m_item.item_name,\n" + 
			"SUM(t_bill_detail.order_qty) as order_qty,\n" + 
			"SUM(t_bill_detail.bill_qty) as bill_qty,\n" + 
			"\n" + 
			"coalesce((SELECT sum(t_grn_gvn.apr_qty_acc) as apr_qty  from t_grn_gvn_header,t_grn_gvn, m_franchisee,m_cat_sub s,m_item i\n" + 
			"		 WHERE m_franchisee.fr_id=t_grn_gvn_header.fr_id and  t_grn_gvn.item_id=i.id  and i.item_grp2=s.sub_cat_id  and t_grn_gvn_header.fr_id IN (t_bill_header.fr_id) and i.id=:itemId\n" + 
			"		 AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id \n" + 
			"		 ),0) as grn_qty\n" + 
			"\n" + 
			"from t_bill_detail,t_bill_header,m_franchisee,m_item,m_cat_sub\n" + 
			"where t_bill_detail.bill_no In(select bill_no from t_bill_header\n" + 
			"where bill_date between :fromDate and :toDate and fr_id in(:frId))  and t_bill_detail.item_id=:itemId\n" + 
			"And t_bill_header.fr_id=m_franchisee.fr_id and t_bill_header.del_status=0 \n" + 
			"And m_item.id=t_bill_detail.item_id And m_cat_sub.sub_cat_id=m_item.item_grp2 And t_bill_header.bill_no=t_bill_detail.bill_no\n" + 
			"group by t_bill_header.fr_id,m_item.id order by t_bill_header.fr_id,m_item.item_grp2",nativeQuery=true)
	List<CategoryWiseOrderData> getItemSubCatStockReport(@Param("fromDate")String fromDateYMD,@Param("toDate") String toDateYMD,@Param("frId") List<String> frId,
			@Param("itemId")int itemId);


}
