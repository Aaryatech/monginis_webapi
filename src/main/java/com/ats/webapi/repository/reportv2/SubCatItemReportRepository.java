package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.reportv2.SubCatItemReport;
@Repository
public interface SubCatItemReportRepository extends JpaRepository<SubCatItemReport, Integer>{

	
	@Query(value = " select uuid() as crnd_id,c.sub_cat_id,c.sub_cat_name,c.fr_id,c.fr_name,c.item_id,c.item_name,c.cat_id,round(coalesce(c.sold_amt,0),2) as sold_amt,c.sold_qty,round(coalesce(c.var_amt,0),2) as ret_amt,round(coalesce(c.var_qty,0),2) as ret_qty,round(coalesce(d.var_amt,0),2) as var_amt,round(coalesce(d.var_qty,0),2) as var_qty from (select a.bill_detail_no,a.sold_amt,a.sold_qty,a.fr_name,a.cat_id,a.sub_cat_id,a.sub_cat_name,a.fr_id,a.item_id,a.item_name,b.var_amt as var_amt,b.var_qty from  (SELECT\n" + 
			"        td.bill_detail_no,\n" + 
			"        SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name ,\n" + 
			"        f.fr_id ,\n" + 
			"        m_item.id as item_id,\n" + 
			"        m_item.item_name,m_item.item_grp1 as cat_id          \n" + 
			"    FROM\n" + 
			"        t_bill_header tb,\n" + 
			"        t_bill_detail td,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_item           \n" + 
			"    WHERE\n" + 
			"        tb.del_status=0                   \n" + 
			"        AND tb.fr_id IN(\n" + 
			"          :frIdList     \n" + 
			"        )                   \n" + 
			"        AND tb.bill_no=td.bill_no                   \n" + 
			"        AND tb.bill_date BETWEEN :fromDate AND :toDate       \n" + 
			"        AND f.fr_id=tb.fr_id                   \n" + 
			"        AND m_item.id=td.item_id                   \n" + 
			"        AND m_item.item_grp2=sc.sub_cat_id              \n" + 
			"        AND m_item.item_grp1!=5   and tb.del_status=0        \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"          :subCatIdList   \n" + 
			"        )            \n" + 
			"    GROUP BY\n" + 
			"        tb.fr_id,\n" + 
			"        m_item.id                              \n" + 
			"    UNION\n" + 
			"    All                  SELECT\n" + 
			"        td.bill_detail_no,\n" + 
			"        SUM(td.grand_total) AS sold_amt,\n" + 
			"        SUM(td.bill_qty) AS sold_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name ,\n" + 
			"        f.fr_id ,\n" + 
			"        m_sp_cake.sp_id as item_id,\n" + 
			"        m_sp_cake.sp_name as item_name ,5 as cat_id              \n" + 
			"    FROM\n" + 
			"        t_bill_header tb,\n" + 
			"        t_bill_detail td,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_sp_cake           \n" + 
			"    WHERE\n" + 
			"        tb.del_status=0                   \n" + 
			"        AND tb.fr_id IN(\n" + 
			"         :frIdList   \n" + 
			"        )                   \n" + 
			"        AND tb.bill_no=td.bill_no                   \n" + 
			"        AND tb.bill_date BETWEEN  :fromDate AND :toDate     \n" + 
			"        AND f.fr_id=tb.fr_id                   \n" + 
			"        AND m_sp_cake.sp_id=td.item_id    and tb.del_status=0                                   \n" + 
			"        AND td.cat_id=5  \n" + 
			"        AND sc.cat_id=5          \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"        :subCatIdList       \n" + 
			"        )            \n" + 
			"    GROUP BY\n" + 
			"        tb.fr_id,\n" + 
			"        m_sp_cake.sp_id ) a left join (SELECT\n" + 
			"        t_credit_note_details.crnd_id,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        f.fr_id ,\n" + 
			"        m_item.id as item_id,\n" + 
			"        m_item.item_name          \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_item           \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id                   \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate                 \n" + 
			"        AND f.fr_id=t_credit_note_header.fr_id                   \n" + 
			"        AND m_item.id=t_credit_note_details.item_id                   \n" + 
			"        AND m_item.item_grp2=sc.sub_cat_id                   \n" + 
			"        AND t_credit_note_details.cat_id !=5 and t_credit_note_details.del_status=0                    \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"          :frIdList      \n" + 
			"        )                   \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"         :subCatIdList\n" + 
			"        )                   \n" + 
			"        AND t_credit_note_details.is_grn=1                   \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_header.fr_id,\n" + 
			"        m_item.id                           \n" + 
			"    UNION\n" + 
			"    ALL                   SELECT\n" + 
			"        t_credit_note_details.crnd_id,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        f.fr_id ,\n" + 
			"        m_sp_cake.sp_id as item_id,\n" + 
			"        m_sp_cake.sp_name          \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_sp_cake           \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id                   \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN  :fromDate AND :toDate                    \n" + 
			"        AND f.fr_id=t_credit_note_header.fr_id                   \n" + 
			"        AND m_sp_cake.sp_id=t_credit_note_details.item_id               \n" + 
			"        AND t_credit_note_details.cat_id =5  and t_credit_note_details.del_status=0                                   \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"            :frIdList       \n" + 
			"        )     \n" + 
			"        AND sc.cat_id=5               \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"          :subCatIdList   \n" + 
			"        )                   \n" + 
			"        AND t_credit_note_details.is_grn=1                   \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_header.fr_id,\n" + 
			"        m_sp_cake.sp_id) b on b.item_id=a.item_id and  a.fr_id=b.fr_id  and a.sub_cat_id=b.sub_cat_id) c\n" + 
			"        left join\n" + 
			"        (\n" + 
			"         SELECT\n" + 
			"        t_credit_note_details.crnd_id,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        f.fr_id ,\n" + 
			"        m_item.id as item_id,\n" + 
			"        m_item.item_name          \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_item           \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id                   \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN   :fromDate AND :toDate    \n" + 
			"        AND f.fr_id=t_credit_note_header.fr_id                   \n" + 
			"        AND m_item.id=t_credit_note_details.item_id                   \n" + 
			"        AND m_item.item_grp2=sc.sub_cat_id                   \n" + 
			"        AND t_credit_note_details.cat_id !=5  and t_credit_note_details.del_status=0                       \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"          :frIdList        \n" + 
			"        )                   \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"           :subCatIdList     \n" + 
			"        )                   \n" + 
			"        AND t_credit_note_details.is_grn=0                 \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_header.fr_id,\n" + 
			"        m_item.id                           \n" + 
			"    UNION\n" + 
			"    ALL                   SELECT\n" + 
			"        t_credit_note_details.crnd_id,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,\n" + 
			"        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,\n" + 
			"        f.fr_name,\n" + 
			"        sc.sub_cat_id,\n" + 
			"        sc.sub_cat_name,\n" + 
			"        f.fr_id ,\n" + 
			"        m_sp_cake.sp_id as item_id,\n" + 
			"        m_sp_cake.sp_name          \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details,\n" + 
			"        m_franchisee f ,\n" + 
			"        m_cat_sub sc ,\n" + 
			"        m_sp_cake           \n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id                   \n" + 
			"        AND t_credit_note_header.crn_date BETWEEN   :fromDate AND :toDate      \n" + 
			"        AND f.fr_id=t_credit_note_header.fr_id                   \n" + 
			"        AND m_sp_cake.sp_id=t_credit_note_details.item_id               \n" + 
			"        AND t_credit_note_details.cat_id =5   and t_credit_note_details.del_status=0                                   \n" + 
			"        AND t_credit_note_header.fr_id IN(\n" + 
			"            :frIdList     \n" + 
			"        )     \n" + 
			"        AND sc.cat_id=5               \n" + 
			"        AND sc.sub_cat_id IN(\n" + 
			"           :subCatIdList      \n" + 
			"        )                   \n" + 
			"        AND t_credit_note_details.is_grn=0                   \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_header.fr_id,\n" + 
			"        m_sp_cake.sp_id\n" + 
			"        ) d on d.item_id=c.item_id and d.fr_id=c.fr_id  and d.sub_cat_id=c.sub_cat_id", nativeQuery = true)
	List<SubCatItemReport> getData( @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
