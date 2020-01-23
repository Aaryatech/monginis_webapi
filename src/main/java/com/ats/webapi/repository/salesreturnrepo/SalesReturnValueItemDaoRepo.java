package com.ats.webapi.repository.salesreturnrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesvaluereport.SalesReturnValueDao;
import com.ats.webapi.model.salesvaluereport.SalesReturnValueItemDao;

public interface SalesReturnValueItemDaoRepo extends JpaRepository<SalesReturnValueItemDao, Integer> {

	@Query(value = "select   uuid() as id,a.item_id,round(coalesce(b.grand_total,0),2) as grand_total,round(coalesce(c.grn_qty,0),2) as grn_qty,round(coalesce(d.gvn_qty,0),2) as  gvn_qty\n" + 
			"from \n" + 
			"(select\n" + 
			"        id as item_id \n" + 
			"    from\n" + 
			"        m_item     \n" + 
			"    where\n" + 
			"        m_item.item_grp2 IN (\n" + 
			"          :subCatId\n" + 
			"        )         \n" + 
			"        and m_item.del_status=0 ) a\n" + 
			"left join \n" + 
			"\n" + 
			"(SELECT t_bill_detail.item_id,\n" + 
			"            SUM(t_bill_detail.grand_total) as grand_total           \n" + 
			"        FROM\n" + 
			"            t_bill_detail,\n" + 
			"            t_bill_header         \n" + 
			"        WHERE\n" + 
			"            DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month             \n" + 
			"            AND t_bill_header.del_status=0             \n" + 
			"            And t_bill_header.bill_no=t_bill_detail.bill_no             \n" + 
			"            and t_bill_detail.cat_id!=5 and t_bill_detail.del_status=0            \n" + 
			"           group by t_bill_detail.item_id) b on a.item_id=b.item_id\n" + 
			"left join \n" + 
			"\n" + 
			"(select t_credit_note_details.item_id,\n" + 
			"            SUM(grn_gvn_amt) as grn_qty         \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details                     \n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id             \n" + 
			"            and t_credit_note_header.is_grn=1             \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month             \n" + 
			"            and t_credit_note_details.cat_id!=5   and t_credit_note_details.del_status=0             \n" + 
			"            group by t_credit_note_details.item_id) c  on c.item_id=a.item_id           \n" + 
			"left join\n" + 
			"(select t_credit_note_details.item_id,\n" + 
			"            SUM(grn_gvn_amt) as gvn_qty         \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details                     \n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id               \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month         \n" + 
			"            and t_credit_note_header.is_grn=0             \n" + 
			"            and t_credit_note_details.cat_id!=5     and t_credit_note_details.del_status=0         \n" + 
			"            group by  t_credit_note_details.item_id) d on d.item_id=a.item_id  \n" + 
			"", nativeQuery = true)
	List<SalesReturnValueItemDao> getSalesReturnValueItemReport1(@Param("month") String month,
			@Param("subCatId") List<Integer> subCatId);

	@Query(value = "select   uuid() as id,a.item_id,round(coalesce(b.grand_total,0),2) as grand_total,round(coalesce(c.grn_qty,0),2) as grn_qty,round(coalesce(d.gvn_qty,0),2) as  gvn_qty\n" + 
			"from \n" + 
			"(select\n" + 
			"        sp_id as item_id \n" + 
			"    from\n" + 
			"        m_sp_cake  \n" + 
			"    where\n" + 
			"         m_sp_cake.del_status=0 ) a\n" + 
			"left join \n" + 
			"\n" + 
			"(SELECT t_bill_detail.item_id,\n" + 
			"            SUM(t_bill_detail.grand_total) as grand_total           \n" + 
			"        FROM\n" + 
			"            t_bill_detail,\n" + 
			"            t_bill_header         \n" + 
			"        WHERE\n" + 
			"            DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month             \n" + 
			"            AND t_bill_header.del_status=0             \n" + 
			"            And t_bill_header.bill_no=t_bill_detail.bill_no             \n" + 
			"            and t_bill_detail.cat_id=5 and t_bill_detail.del_status=0            \n" + 
			"           group by t_bill_detail.item_id) b on a.item_id=b.item_id\n" + 
			"left join \n" + 
			"\n" + 
			"(select t_credit_note_details.item_id,\n" + 
			"            SUM(grn_gvn_amt) as grn_qty         \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details                     \n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id             \n" + 
			"            and t_credit_note_header.is_grn=1             \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month             \n" + 
			"            and t_credit_note_details.cat_id=5   and t_credit_note_details.del_status=0             \n" + 
			"            group by t_credit_note_details.item_id) c  on c.item_id=a.item_id           \n" + 
			"left join\n" + 
			"(select t_credit_note_details.item_id,\n" + 
			"            SUM(grn_gvn_amt) as gvn_qty         \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details                     \n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id               \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month         \n" + 
			"            and t_credit_note_header.is_grn=0             \n" + 
			"            and t_credit_note_details.cat_id=5     and t_credit_note_details.del_status=0         \n" + 
			"            group by  t_credit_note_details.item_id) d on d.item_id=a.item_id  \n" + 
			"", nativeQuery = true)
	List<SalesReturnValueItemDao> getSalesReturnValueSpReport1(@Param("month") String month);

}
