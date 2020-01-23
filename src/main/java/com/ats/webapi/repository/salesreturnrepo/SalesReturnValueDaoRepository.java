package com.ats.webapi.repository.salesreturnrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesvaluereport.SalesReturnValueDao;

public interface SalesReturnValueDaoRepository extends JpaRepository<SalesReturnValueDao, Integer>{

/*	@Query(value="select CONCAT(:month,\"\",sub_cat_id) as id,sub_cat_id,coalesce((SELECT  SUM(t_bill_detail.grand_total) as grand_total   FROM    t_bill_detail,t_bill_header,m_item    WHERE   DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month AND t_bill_header.del_status=0 And t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cat_id!=5 and m_item.item_grp2=m_cat_sub.sub_cat_id and m_item.id=t_bill_detail.item_id),0) as grand_total,\n" + 
			"\n" + 
			"coalesce((select SUM(grn_gvn_amt) as grn_qty from t_credit_note_header,t_credit_note_details,m_item where t_credit_note_header.crn_id=t_credit_note_details.crn_id and t_credit_note_header.is_grn=1 and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month and t_credit_note_details.cat_id!=5 and m_item.id=t_credit_note_details.item_id and m_item.item_grp2=m_cat_sub.sub_cat_id),0) as grn_qty,\n" + 
			"\n" + 
			"coalesce((select SUM(grn_gvn_amt) as gvn_qty from t_credit_note_header,t_credit_note_details,m_item where t_credit_note_header.crn_id=t_credit_note_details.crn_id  and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month and t_credit_note_header.is_grn=0 and t_credit_note_details.cat_id!=5 and m_item.id=t_credit_note_details.item_id and m_item.item_grp2=m_cat_sub.sub_cat_id),0) as gvn_qty\n" + 
			"\n" + 
			"from m_cat_sub where m_cat_sub.cat_id!=5 and m_cat_sub.del_status=0\n" + 
			"\n" + 
			"UNION ALL\n" + 
			"select  CONCAT(:month,\"\",sub_cat_id) as id,m_cat_sub.sub_cat_id,coalesce((SELECT\n" + 
			"        SUM(t_bill_detail.grand_total) as bill_qty\n" + 
			"          FROM\n" + 
			"        t_bill_detail,t_bill_header,m_sp_cake\n" + 
			"    WHERE\n" + 
			"        DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month\n" + 
			"        AND t_bill_header.del_status=0 And t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cat_id=5 and  m_sp_cake.sp_id=t_bill_detail.item_id),0) as bill_qty,\n" + 
			"        0 as grn_qty,\n" + 
			"        coalesce((select SUM(grn_gvn_amt) as gvn_qty from t_credit_note_header,t_credit_note_details,m_sp_cake where t_credit_note_header.crn_id=t_credit_note_details.crn_id and t_credit_note_header.is_grn=0 and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month and t_credit_note_details.cat_id=5 and m_sp_cake.sp_id=t_credit_note_details.item_id),0) as gvn_qty\n" + 
			"        from m_cat_sub where m_cat_sub.cat_id=5 and m_cat_sub.del_status=0",nativeQuery=true)*/
	
	@Query(value=" select\n" + 
			"        uuid() as id,\n" + 
			"        sub_cat_id,\n" + 
			"        coalesce((SELECT\n" + 
			"            SUM(t_bill_detail.grand_total) as grand_total   \n" + 
			"        FROM\n" + 
			"            t_bill_detail,\n" + 
			"            t_bill_header\n" + 
			"        WHERE\n" + 
			"            DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month \n" + 
			"            AND t_bill_header.del_status=0 \n" + 
			"            And t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"            and t_bill_detail.cat_id!=5 \n" + 
			"            and t_bill_detail.item_id IN (select id from m_item where item_grp2=sub_cat_id) ),\n" + 
			"        0) as grand_total,\n" + 
			"        coalesce((select\n" + 
			"            SUM(grn_gvn_amt) as grn_qty \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details\n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"            and t_credit_note_header.is_grn=1 \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month\n" + 
			"            and t_credit_note_details.cat_id!=5 \n" + 
			"            and t_credit_note_details.item_id  IN (select id from m_item where item_grp2=sub_cat_id)\n" + 
			"           ),\n" + 
			"        0) as grn_qty,\n" + 
			"        coalesce((select\n" + 
			"            SUM(grn_gvn_amt) as gvn_qty \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details\n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id  \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month\n" + 
			"            and t_credit_note_header.is_grn=0 \n" + 
			"            and t_credit_note_details.cat_id!=5 \n" + 
			"            and t_credit_note_details.item_id  IN (select id from m_item where item_grp2=sub_cat_id)\n" + 
			"           ),\n" + 
			"        0) as gvn_qty  \n" + 
			"    from\n" + 
			"        m_cat_sub \n" + 
			"    where\n" + 
			"        m_cat_sub.cat_id!=5 \n" + 
			"        and m_cat_sub.del_status=0  \n" + 
			"    UNION\n" + 
			"    ALL select\n" + 
			"        uuid() as id,\n" + 
			"        m_cat_sub.sub_cat_id,\n" + 
			"        coalesce((SELECT\n" + 
			"            SUM(t_bill_detail.grand_total) as bill_qty           \n" + 
			"        FROM\n" + 
			"            t_bill_detail,\n" + 
			"            t_bill_header,\n" + 
			"            m_sp_cake     \n" + 
			"        WHERE\n" + 
			"            DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month         \n" + 
			"            AND t_bill_header.del_status=0 \n" + 
			"            And t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"            and t_bill_detail.cat_id=5 ),\n" + 
			"        0) as bill_qty,\n" + 
			"        0 as grn_qty,\n" + 
			"        coalesce((select\n" + 
			"            SUM(grn_gvn_amt) as gvn_qty \n" + 
			"        from\n" + 
			"            t_credit_note_header,\n" + 
			"            t_credit_note_details,\n" + 
			"            m_sp_cake \n" + 
			"        where\n" + 
			"            t_credit_note_header.crn_id=t_credit_note_details.crn_id \n" + 
			"            and t_credit_note_header.is_grn=0 \n" + 
			"            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month \n" + 
			"            and t_credit_note_details.cat_id=5 \n" + 
			"           ),\n" + 
			"        0) as gvn_qty         \n" + 
			"    from\n" + 
			"        m_cat_sub \n" + 
			"    where\n" + 
			"        m_cat_sub.cat_id=5 \n" + 
			"        and m_cat_sub.del_status=0",nativeQuery=true)
	List<SalesReturnValueDao> getSalesReturnValueReport(@Param("month")String month);

}
