package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemWiseDetail;

@Repository
public interface ItemWiseDetailRepository extends JpaRepository<ItemWiseDetail, Long>{

	@Query(value="SELECT t_bill_detail.bill_detail_no, t_bill_detail.bill_no ,t_bill_header.bill_date, t_bill_detail.item_id ,  m_item.item_name ,t_bill_detail.rate,COALESCE(SUM(bill_qty),0) AS qty, COALESCE(SUM(t_bill_detail.grand_total),0) AS total ,t_bill_detail.grn_type FROM t_bill_detail , m_item, t_bill_header WHERE  m_item.id= t_bill_detail.item_id AND t_bill_detail.bill_no IN(SELECT bill_no FROM t_bill_header WHERE bill_date BETWEEN :fromDate AND :toDate AND fr_id=:frId) AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_detail.cat_id=:catId GROUP BY t_bill_detail.item_id, t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> findItemWiseDetailReport(@Param("frId")int frId,@Param("catId")int catId,@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	/*@Query(value="SELECT t_bill_detail.bill_detail_no, t_bill_detail.bill_no ,t_bill_header.bill_date, t_bill_detail.item_id ,  m_sp_cake.sp_name AS item_name ,t_bill_detail.rate,COALESCE(SUM(bill_qty),0) AS qty, COALESCE(SUM(t_bill_detail.grand_total),0) AS total ,t_bill_detail.grn_type FROM t_bill_detail , m_sp_cake, t_bill_header WHERE  m_sp_cake.sp_id= t_bill_detail.item_id AND t_bill_detail.bill_no IN(SELECT bill_no FROM t_bill_header WHERE bill_date BETWEEN :fromDate AND :toDate AND fr_id=:frId) AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_detail.cat_id=:catId GROUP BY t_bill_detail.item_id, t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> findSpecialCakeWiseDetailReport(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	*/
	
	@Query(value="SELECT  \n" + 
			"			    t_bill_detail.bill_detail_no,  \n" + 
			"			    t_bill_detail.bill_no,  \n" + 
			"			    t_bill_header.bill_date,  \n" + 
			"			    t_bill_detail.item_id,  \n" + 
			"			    CASE WHEN t_bill_detail.menu_id NOT IN(  \n" + 
			"			    SELECT  \n" + 
			"			        menu_id  \n" + 
			"			    FROM  \n" + 
			"			        m_fr_menu_show  \n" + 
			"			    WHERE  \n" + 
			"			        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4  \n" + 
			"			) THEN(  \n" + 
			"			    SELECT  \n" + 
			"			        sp_name  \n" + 
			"			    FROM  \n" + 
			"			        m_sp_cake  \n" + 
			"			    WHERE  \n" + 
			"			        sp_id = t_bill_detail.item_id  \n" + 
			"			) ELSE(  \n" + 
			"			    SELECT  \n" + 
			"			        SUBSTRING_INDEX(item_id, '#', -1)  \n" + 
			"			    FROM  \n" + 
			"			        t_sp_cake  \n" + 
			"			    WHERE  \n" + 
			"			        sp_order_no = t_bill_detail.order_id  \n" + 
			"			)  \n" + 
			"			END AS item_name,  \n" + 
			"			t_bill_detail.rate,  \n" + 
			"			COALESCE((bill_qty),  \n" + 
			"			0) AS qty,  \n" + 
			"			COALESCE(  \n" + 
			"			    (t_bill_detail.grand_total),  \n" + 
			"			    0  \n" + 
			"			) AS total,  \n" + 
			"			t_bill_detail.grn_type  \n" + 
			"			FROM  \n" + 
			"			    t_bill_detail,  \n" + 
			"			    t_bill_header  \n" + 
			"			WHERE  \n" + 
			"			    t_bill_detail.bill_no IN(  \n" + 
			"			    SELECT  \n" + 
			"			        bill_no  \n" + 
			"			    FROM  \n" + 
			"			        t_bill_header  \n" + 
			"			    WHERE  \n" + 
			"			        bill_date BETWEEN :fromDate AND :toDate AND fr_id = :frId  \n" + 
			"			) AND t_bill_detail.bill_no = t_bill_header.bill_no AND t_bill_detail.cat_id = :catId  \n" + 
			"",nativeQuery=true)
	List<ItemWiseDetail> findSpecialCakeWiseDetailReport(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	

}
