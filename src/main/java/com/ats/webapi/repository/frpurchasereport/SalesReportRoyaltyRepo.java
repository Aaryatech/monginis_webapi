package com.ats.webapi.repository.frpurchasereport;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.report.frpurchase.SalesReportRoyalty;

public interface SalesReportRoyaltyRepo extends JpaRepository<SalesReportRoyalty, Integer> {
	//report 5
	@Query(value="select a.id,a.item_name,a.cat_name,a.cat_id,coalesce(b.t_bill_qty,0) as t_bill_qty,round(coalesce(b.t_bill_taxable_amt,0),2) as t_bill_taxable_amt,coalesce(c.t_grn_qty,0) as t_grn_qty,round(coalesce(c.t_grn_taxable_amt,0),2) as t_grn_taxable_amt,coalesce(d.t_gvn_qty,0) as t_gvn_qty,round(coalesce(d.t_gvn_taxable_amt,0),2) as t_gvn_taxable_amt from (SELECT\n" + 
			"        m_item.id,\n" + 
			"        m_item.item_name,\n" + 
			"        m_category.cat_name,\n" + 
			"        m_category.cat_id\n" + 
			"    FROM\n" + 
			"        m_item,\n" + 
			"        m_category \n" + 
			"    WHERE\n" + 
			"        m_item.item_grp1=m_category.cat_id and m_item.del_status=0\n" + 
			"        ) a left join  (SELECT t_bill_detail.item_id,\n" + 
			"            SUM(t_bill_detail.bill_qty) as t_bill_qty, SUM(t_bill_detail.taxable_amt) as t_bill_taxable_amt\n" + 
			"        FROM\n" + 
			"            t_bill_detail,\n" + 
			"            t_bill_header \n" + 
			"        WHERE\n" + 
			"            t_bill_header.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"            AND t_bill_header.bill_no=t_bill_detail.bill_no and  t_bill_header.fr_id IN(:frIdList) \n" + 
			"            AND t_bill_header.del_status=0 and t_bill_detail.del_status=0 and t_bill_detail.cat_id!=5 group by t_bill_detail.item_id) b \n" + 
			"            \n" + 
			"            on a.id=b.item_id \n" + 
			"            \n" + 
			"            left join (\n" + 
			"            SELECT t_credit_note_details.item_id,\n" + 
			"            SUM(t_credit_note_details.grn_gvn_qty)  as t_grn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_grn_taxable_amt\n" + 
			"        FROM\n" + 
			"            t_credit_note_details,\n" + 
			"            t_credit_note_header \n" + 
			"        WHERE\n" + 
			"            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"            AND t_credit_note_header.is_grn=1 \n" + 
			"             AND t_credit_note_header.fr_id IN(:frIdList) \n" + 
			"            AND  t_credit_note_details.del_status=0  and t_credit_note_details.cat_id!=5 group by t_credit_note_details.item_id) c on a.id=c.item_id  \n" + 
			"            \n" + 
			"            left join (\n" + 
			"            SELECT t_credit_note_details.item_id,\n" + 
			"            SUM(t_credit_note_details.grn_gvn_qty)  as t_gvn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_gvn_taxable_amt\n" + 
			"        FROM\n" + 
			"            t_credit_note_details,\n" + 
			"            t_credit_note_header \n" + 
			"        WHERE\n" + 
			"            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"            AND t_credit_note_header.is_grn=0 \n" + 
			"             AND t_credit_note_header.fr_id IN(:frIdList) \n" + 
			"            AND  t_credit_note_details.del_status=0  and t_credit_note_details.cat_id!=5 group by t_credit_note_details.item_id) d on a.id=d.item_id   "
			+ "union all "
			+ "select a.id,a.item_name,a.cat_name,a.cat_id,coalesce(b.t_bill_qty,0) as t_bill_qty,round(coalesce(b.t_bill_taxable_amt,0),2) as t_bill_taxable_amt,coalesce(c.t_grn_qty,0) as t_grn_qty,round(coalesce(c.t_grn_taxable_amt,0),2) as t_grn_taxable_amt,coalesce(d.t_gvn_qty,0) as t_gvn_qty,round(coalesce(d.t_gvn_taxable_amt,0),2) as t_gvn_taxable_amt from (SELECT " + 
			"			        s.sp_id as id, " + 
			"			       concat(s.sp_name,'--',s.sp_code) as item_name, " + 
			"			      'Special Cake' as cat_name, " + 
			"			      5 as cat_id " + 
			"			    FROM " + 
			"			        m_sp_cake s " + 
			"			   WHERE " + 
			"			        s.del_status=0 " + 
			"			       ) a left join  (SELECT t_bill_detail.item_id, " + 
			"			           SUM(t_bill_detail.bill_qty) as t_bill_qty, SUM(t_bill_detail.taxable_amt) as t_bill_taxable_amt" + 
			"			        FROM" + 
			"			            t_bill_detail," + 
			"			            t_bill_header " + 
			"			        WHERE" + 
			"			            t_bill_header.bill_date BETWEEN :fromDate AND :toDate " + 
			"			            AND t_bill_header.bill_no=t_bill_detail.bill_no and  t_bill_header.fr_id IN(:frIdList) " + 
			"			            AND t_bill_header.del_status=0 and t_bill_detail.del_status=0 and t_bill_detail.cat_id=5 group by t_bill_detail.item_id) b " + 
			"			            " + 
			"			            on a.id=b.item_id " + 
			"			            " + 
			"			            left join (" + 
			"			            SELECT t_credit_note_details.item_id," + 
			"			            SUM(t_credit_note_details.grn_gvn_qty)  as t_grn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_grn_taxable_amt" + 
			"			        FROM" + 
			"			            t_credit_note_details," + 
			"			            t_credit_note_header " + 
			"			        WHERE" + 
			"			            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate " + 
			"			            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id " + 
			"			            AND t_credit_note_header.is_grn=1 " + 
			"			             AND t_credit_note_header.fr_id IN(:frIdList) " + 
			"			            AND  t_credit_note_details.del_status=0  and t_credit_note_details.cat_id=5 group by t_credit_note_details.item_id) c on a.id=c.item_id  " + 
			"			            " + 
			"			            left join (" + 
			"			            SELECT t_credit_note_details.item_id," + 
			"			            SUM(t_credit_note_details.grn_gvn_qty)  as t_gvn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_gvn_taxable_amt" + 
			"			        FROM" + 
			"			            t_credit_note_details," + 
			"			            t_credit_note_header " + 
			"			        WHERE" + 
			"			            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate " + 
			"			            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id " + 
			"			            AND t_credit_note_header.is_grn=0 " + 
			"			             AND t_credit_note_header.fr_id IN(:frIdList) " + 
			"			            AND  t_credit_note_details.del_status=0  and t_credit_note_details.cat_id=5 group by t_credit_note_details.item_id) d on a.id=d.item_id "
			+ "",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyalty(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	//report 5 all fr //Ok Tested changed to credit note 11 april
	@Query(value="select a.id,a.item_name,a.cat_name,a.cat_id,coalesce(b.t_bill_qty,0) as t_bill_qty,round(coalesce(b.t_bill_taxable_amt,0),2) as t_bill_taxable_amt,coalesce(c.t_grn_qty,0) as t_grn_qty,round(coalesce(c.t_grn_taxable_amt,0),2) as t_grn_taxable_amt,coalesce(d.t_gvn_qty,0) as t_gvn_qty,round(coalesce(d.t_gvn_taxable_amt,0),2) as t_gvn_taxable_amt from (SELECT\n" + 
			"        m_item.id,\n" + 
			"        m_item.item_name,\n" + 
			"        m_category.cat_name,\n" + 
			"        m_category.cat_id\n" + 
			"    FROM\n" + 
			"        m_item,\n" + 
			"        m_category \n" + 
			"    WHERE\n" + 
			"        m_item.item_grp1=m_category.cat_id and m_item.del_status=0\n" + 
			"        ) a left join  (SELECT t_bill_detail.item_id,\n" + 
			"            SUM(t_bill_detail.bill_qty) as t_bill_qty, SUM(t_bill_detail.taxable_amt) as t_bill_taxable_amt\n" + 
			"        FROM\n" + 
			"            t_bill_detail,\n" + 
			"            t_bill_header \n" + 
			"        WHERE\n" + 
			"            t_bill_header.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"            AND t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"            AND t_bill_header.del_status=0 and t_bill_detail.del_status=0 and t_bill_detail.cat_id!=5 group by t_bill_detail.item_id) b \n" + 
			"            \n" + 
			"            on a.id=b.item_id \n" + 
			"            \n" + 
			"            left join (\n" + 
			"            SELECT t_credit_note_details.item_id,\n" + 
			"            SUM(t_credit_note_details.grn_gvn_qty)  as t_grn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_grn_taxable_amt\n" + 
			"        FROM\n" + 
			"            t_credit_note_details,\n" + 
			"            t_credit_note_header \n" + 
			"        WHERE\n" + 
			"            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"            AND t_credit_note_header.is_grn=1 \n" + 
			"            AND  t_credit_note_details.del_status=0 and t_credit_note_details.cat_id!=5 group by t_credit_note_details.item_id) c on a.id=c.item_id  \n" + 
			"            \n" + 
			"            left join (\n" + 
			"            SELECT t_credit_note_details.item_id,\n" + 
			"            SUM(t_credit_note_details.grn_gvn_qty)  as t_gvn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_gvn_taxable_amt\n" + 
			"        FROM\n" + 
			"            t_credit_note_details,\n" + 
			"            t_credit_note_header \n" + 
			"        WHERE\n" + 
			"            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"            AND t_credit_note_header.is_grn=0 \n" + 
			"            AND  t_credit_note_details.del_status=0 and t_credit_note_details.cat_id!=5 group by t_credit_note_details.item_id) d on a.id=d.item_id "
			+ "union all"
			+ " select a.id,a.item_name,a.cat_name,a.cat_id,coalesce(b.t_bill_qty,0) as t_bill_qty,round(coalesce(b.t_bill_taxable_amt,0),2) as t_bill_taxable_amt,coalesce(c.t_grn_qty,0) as t_grn_qty,round(coalesce(c.t_grn_taxable_amt,0),2) as t_grn_taxable_amt,coalesce(d.t_gvn_qty,0) as t_gvn_qty,round(coalesce(d.t_gvn_taxable_amt,0),2) as t_gvn_taxable_amt from (SELECT " + 
			"			        s.sp_id as id," + 
			"			        concat(s.sp_name,'--',s.sp_code) as item_name," + 
			"			       'Special Cake' as cat_name," + 
			"			         5 as cat_id" + 
			"			    FROM" + 
			"			       m_sp_cake s " + 
			"			    WHERE" + 
			"			         s.del_status=0 " + 
			"			        ) a left join  (SELECT t_bill_detail.item_id," + 
			"			            SUM(t_bill_detail.bill_qty) as t_bill_qty, SUM(t_bill_detail.taxable_amt) as t_bill_taxable_amt" + 
			"			        FROM" + 
			"			            t_bill_detail," + 
			"			            t_bill_header " + 
			"			        WHERE" + 
			"			            t_bill_header.bill_date BETWEEN :fromDate AND :toDate " + 
			"			            AND t_bill_header.bill_no=t_bill_detail.bill_no " + 
			"			            AND t_bill_header.del_status=0 and t_bill_detail.del_status=0 and t_bill_detail.cat_id=5 group by t_bill_detail.item_id) b " + 
			"			            " + 
			"			            on a.id=b.item_id " + 
			"			            " + 
			"			            left join (" + 
			"			            SELECT t_credit_note_details.item_id," + 
			"			            SUM(t_credit_note_details.grn_gvn_qty)  as t_grn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_grn_taxable_amt" + 
			"			        FROM" + 
			"			            t_credit_note_details," + 
			"			            t_credit_note_header " + 
			"			        WHERE" + 
			"			            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate " + 
			"			            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id " + 
			"			            AND t_credit_note_header.is_grn=1 " + 
			"			            AND  t_credit_note_details.del_status=0 and t_credit_note_details.cat_id=5 group by t_credit_note_details.item_id) c on a.id=c.item_id  " + 
			"			            " + 
			"			            left join (" + 
			"			            SELECT t_credit_note_details.item_id," + 
			"			            SUM(t_credit_note_details.grn_gvn_qty)  as t_gvn_qty, SUM(t_credit_note_details.taxable_amt) AS  t_gvn_taxable_amt" + 
			"			        FROM" + 
			"			            t_credit_note_details," + 
			"			            t_credit_note_header " + 
			"			        WHERE" + 
			"			            t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate " + 
			"			            AND t_credit_note_header.crn_id=t_credit_note_details.crn_id " + 
			"			            AND t_credit_note_header.is_grn=0 " + 
			"			            AND  t_credit_note_details.del_status=0 and t_credit_note_details.cat_id=5 group by t_credit_note_details.item_id) d on a.id=d.item_id",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyaltyAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
/*	//report 5 all fr //Ok Tested
		@Query(value=" SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id  AND t_bill_header.del_status=0),0) AS t_bill_qty,\n" + 
				"\n" + 
				"COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id  AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt,\n" + 
				"\n" + 
				"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date  BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=1  AND t_grn_gvn.del_status=0),0) AS  t_grn_qty,\n" + 
				"\n" + 
				"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=1  AND t_grn_gvn.del_status=0),0) AS  t_grn_taxable_amt,\n" + 
				"\n" + 
				"COALESCE((SELECT SUM(t_grn_gvn.grn_gvn_qty) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=0  AND t_grn_gvn.del_status=0),0) AS  t_gvn_qty,\n" + 
				"\n" + 
				"COALESCE((SELECT SUM(t_grn_gvn.taxable_amt) FROM t_grn_gvn WHERE t_grn_gvn.grn_gvn_date BETWEEN :fromDate AND :toDate AND   m_item.id=t_grn_gvn.item_id AND t_grn_gvn.is_credit_note=1 AND t_grn_gvn.is_grn=0  AND t_grn_gvn.del_status=0),0) AS  t_gvn_taxable_amt\n" + 
				"\n" + 
				"from m_item,m_category where m_item.item_grp1=m_category.cat_id group by m_item.id order by m_category.cat_id",nativeQuery=true)
			
			List<SalesReportRoyalty> getSaleReportRoyaltyAllFr(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
*/
		
	//report no 10 multiple fr and multiple category
	/*@Query(value="  SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, " + 
			"		COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date " + 
			"			BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND " + 
			"			t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS t_bill_qty," + 
			"			COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date " + 
			"			BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id " + 
			"			AND t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt," + 
			"			COALESCE((SELECT SUM(t_credit_note_details.grn_gvn_qty) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_grn_qty," + 
			"			COALESCE((SELECT SUM(t_credit_note_details.taxable_amt) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_grn_taxable_amt," + 
			"			COALESCE((SELECT SUM(t_credit_note_details.grn_gvn_qty) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_gvn_qty," + 
			"			COALESCE((SELECT SUM(t_credit_note_details.taxable_amt) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_gvn_taxable_amt " + 
			"			FROM m_item,m_category where m_item.item_grp1=m_category.cat_id AND m_category.cat_id IN(:catIdList) group by m_item.id order by m_category.cat_id,m_item.item_grp2,m_item.item_name " + 
			"		",nativeQuery=true)*/
		@Query(value="SELECT a.id,a.item_name,a.cat_name,a.cat_id,coalesce(b.t_bill_qty,0) as t_bill_qty,coalesce(b.t_bill_taxable_amt,0)as t_bill_taxable_amt,coalesce(c.t_grn_qty,0) as t_grn_qty,coalesce(c.t_grn_taxable_amt,0)as t_grn_taxable_amt,coalesce(d.t_gvn_qty,0) as t_gvn_qty,coalesce(d.t_gvn_taxable_amt,0) as t_gvn_taxable_amt from (SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id\n" + 
				"FROM m_item,m_category where m_item.item_grp1=m_category.cat_id AND m_category.cat_id IN(:catIdList) group by m_item.id order by m_category.cat_id,m_item.item_grp2,m_item.item_name  ) a LEFT JOIN \n" + 
				"(SELECT t_bill_detail.item_id,SUM(t_bill_detail.bill_qty) as t_bill_qty,SUM(t_bill_detail.grand_total) as t_bill_taxable_amt FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date  \n" + 
				"BETWEEN :fromDate AND :toDate  AND t_bill_header.bill_no=t_bill_detail.bill_no  AND  \n" + 
				"t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0 group by t_bill_detail.item_id)b ON a.id=b.item_id \n" + 
				"LEFT JOIN \n" + 
				"\n" + 
				"(SELECT t_credit_note_details.item_id,SUM(t_credit_note_details.grn_gvn_qty) as t_grn_qty,SUM(t_credit_note_details.grn_gvn_amt) as t_grn_taxable_amt  FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate  AND t_credit_note_header.crn_id=t_credit_note_details.crn_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList) group by t_credit_note_details.item_id) c\n" + 
				"ON c.item_id=b.item_id \n" + 
				"LEFT JOIN \n" + 
				"(SELECT t_credit_note_details.item_id, SUM(t_credit_note_details.grn_gvn_qty) as t_gvn_qty,SUM(t_credit_note_details.grn_gvn_amt) as t_gvn_taxable_amt FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate  AND t_credit_note_header.crn_id=t_credit_note_details.crn_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList) group by t_credit_note_details.item_id) d ON d.item_id=c.item_id \n" + 
				"",nativeQuery=true)
		List<SalesReportRoyalty> getSaleReportRoyConsoByCat(@Param("frIdList") List<String> frIdList,@Param("catIdList") List<String> catIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	//report no 10 all fr and multiple category
	@Query(value=" SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, \n" + 
			"		COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header,m_franchisee WHERE t_bill_header.bill_date\n" + 
			"			BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND \n" + 
			"			t_bill_header.fr_id =m_franchisee.fr_id AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS t_bill_qty,\n" + 
			"			COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header,m_franchisee WHERE t_bill_header.bill_date \n" + 
			"			BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id \n" + 
			"			AND t_bill_header.fr_id  =m_franchisee.fr_id AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt,\n" + 
			"			COALESCE((SELECT SUM(t_credit_note_details.grn_gvn_qty) FROM t_credit_note_details,t_credit_note_header,m_franchisee WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id = m_franchisee.fr_id),0) AS  t_grn_qty,\n" + 
			"			COALESCE((SELECT SUM(t_credit_note_details.taxable_amt) FROM t_credit_note_details,t_credit_note_header,m_franchisee WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id = m_franchisee.fr_id),0) AS  t_grn_taxable_amt,\n" + 
			"			COALESCE((SELECT SUM(t_credit_note_details.grn_gvn_qty) FROM t_credit_note_details,t_credit_note_header,m_franchisee WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id = m_franchisee.fr_id),0) AS  t_gvn_qty,\n" + 
			"			COALESCE((SELECT SUM(t_credit_note_details.taxable_amt) FROM t_credit_note_details,t_credit_note_header,m_franchisee WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id = m_franchisee.fr_id),0) AS  t_gvn_taxable_amt\n" + 
			"			FROM m_item,m_category where m_item.item_grp1=m_category.cat_id AND m_category.cat_id IN(:catIdList) group by m_item.id order by m_category.cat_id,m_item.id\n" + 
			"		",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyConsoByCatAllFr(@Param("catIdList") List<String> catIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	
	//Only For Graph report no 10 :
	@Query(value=" SELECT m_item.id,m_item.item_name,m_category.cat_name,m_category.cat_id, \n" + 
			"\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.bill_qty) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date \n" + 
			"BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id AND \n" + 
			"t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS t_bill_qty,\n" + 
			"			\n" + 
			"COALESCE((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_detail,t_bill_header WHERE t_bill_header.bill_date \n" + 
			"BETWEEN :fromDate AND :toDate AND t_bill_header.bill_no=t_bill_detail.bill_no AND m_item.id=t_bill_detail.item_id \n" + 
			"AND t_bill_header.fr_id IN(:frIdList) AND t_bill_detail.cat_id IN(:catIdList) AND t_bill_header.del_status=0),0) AS  t_bill_taxable_amt,\n" + 
			"		\n" + 
			"			COALESCE((SELECT SUM(t_credit_note_details.grn_gvn_qty) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_grn_qty," + 

"	COALESCE((SELECT SUM(t_credit_note_details.taxable_amt) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=1 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_grn_taxable_amt," + 
"			COALESCE((SELECT SUM(t_credit_note_details.grn_gvn_qty) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_gvn_qty," + 
"			COALESCE((SELECT SUM(t_credit_note_details.taxable_amt) FROM t_credit_note_details,t_credit_note_header WHERE t_credit_note_header.crn_date  BETWEEN :fromDate AND :toDate AND t_credit_note_header.crn_id=t_credit_note_details.crn_id AND m_item.id=t_credit_note_details.item_id  AND t_credit_note_header.is_grn=0 AND t_credit_note_details.cat_id IN(:catIdList) AND  t_credit_note_details.del_status=0 AND t_credit_note_header.fr_id IN(:frIdList)),0) AS  t_gvn_taxable_amt " +
			
			"FROM m_item,m_category where m_item.item_grp1=m_category.cat_id AND m_category.cat_id IN(:catIdList) group by m_category.cat_id order by m_category.cat_id,m_item.id",nativeQuery=true)
		
		List<SalesReportRoyalty> getSaleReportRoyConsoByCatForGraph(@Param("frIdList") List<String> frIdList,@Param("catIdList") List<String> catIdList,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
}
