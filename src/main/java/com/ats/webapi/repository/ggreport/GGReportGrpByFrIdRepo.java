package com.ats.webapi.repository.ggreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvnreport.GGReportGrpByFrId;

public interface GGReportGrpByFrIdRepo extends JpaRepository<GGReportGrpByFrId, Integer> {
	
	//sumit Sir Query report 2
	
/*	@Query(value=" SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, "
			+ " sum(t_grn_gvn.apr_grand_total)as apr_grand_total, sum(t_grn_gvn.grn_gvn_amt) as total_amt,"
			+ " m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty) as req_qty,sum(t_grn_gvn.apr_qty_acc) " + 
			" as apr_qty from t_grn_gvn_header,m_franchisee,t_grn_gvn WHERE t_grn_gvn_header.fr_id IN (:frIdList) "
			+ " AND m_franchisee.fr_id=t_grn_gvn_header.fr_id AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate "
			+ " AND t_grn_gvn_header.is_grn IN (:isGrn) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND "
			+ "t_grn_gvn.fr_id=m_franchisee.fr_id GROUP by t_grn_gvn.fr_id",nativeQuery=true)*/
	
	
	@Query(value="select a.is_grn,a.fr_id,a.apr_grand_total,a.total_amt,a.fr_name,a.req_qty,a.apr_qty,coalesce(( b.bill_amt-c.grn_grand_total),0)  as fr_contr  \n" + 
			"\n" + 
			"\n" + 
			"from\n" + 
			"(\n" + 
			"SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, \n" + 
			"			 sum(t_grn_gvn.apr_grand_total)as apr_grand_total, sum(t_grn_gvn.grn_gvn_amt) as total_amt,\n" + 
			"		     m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty) as req_qty,sum(t_grn_gvn.apr_qty_acc) \n" + 
			"		     as apr_qty \n" + 
			"		     from t_grn_gvn_header,m_franchisee,t_grn_gvn \n" + 
			"		     \n" + 
			"		     WHERE t_grn_gvn_header.fr_id IN (:frId) \n" + 
			"		     AND m_franchisee.fr_id=t_grn_gvn_header.fr_id AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		      AND t_grn_gvn_header.is_grn IN (:isGrn) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND \n" + 
			"			   t_grn_gvn.fr_id=m_franchisee.fr_id  and t_grn_gvn.grn_gvn_status=6  GROUP by t_grn_gvn.fr_id\n" + 
			") a\n" + 
			"LEFT JOIN \n" + 
			"(	   \n" + 
			"			 SELECT   t_grn_gvn_header.fr_id,sum((t_bill_detail.grand_total/t_bill_detail.bill_qty)*t_grn_gvn.apr_qty_acc) as bill_amt FROM t_grn_gvn_header,t_grn_gvn,t_bill_detail WHERE t_grn_gvn_header.grn_gvn_header_id= t_grn_gvn.grn_gvn_header_id and t_grn_gvn.bill_detail_no=t_bill_detail.bill_detail_no and t_grn_gvn_header.fr_id IN (:frId) \n" + 
			"		   AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		      AND t_grn_gvn.is_grn IN (:isGrn)  and t_grn_gvn.grn_gvn_status=6  GROUP by t_grn_gvn_header.fr_id ) b on b.fr_id=a.fr_id  LEFT JOIN \n" + 
			"(	   \n" + 
			"			SELECT t_grn_gvn_header.fr_id, \n" + 
			"			 sum(t_grn_gvn.apr_grand_total)as grn_grand_total\n" + 
			"		     from t_grn_gvn_header,t_grn_gvn \n" + 
			"		     \n" + 
			"		     WHERE t_grn_gvn_header.fr_id IN (:frId) \n" + 
			"		     AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		      AND t_grn_gvn_header.is_grn IN (1) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id  and t_grn_gvn.grn_gvn_status=6  GROUP by t_grn_gvn.fr_id) c\n" + 
			"		      on c.fr_id=a.fr_id",nativeQuery=true)
		List<GGReportGrpByFrId> getGGReportGrpByFrIdSelFr(@Param("fromDate") 
		String fromDate,@Param("toDate") String toDate, @Param("isGrn") List<String> isGrn, @Param("frId") List<String> frIdList);
	
	//sumit Sir Query report 2 all fr Selected 

	/*@Query(value=" SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, "
			+ " sum(t_grn_gvn.apr_grand_total)as apr_grand_total, sum(t_grn_gvn.grn_gvn_amt) as total_amt,"
			+ " m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty) as req_qty,sum(t_grn_gvn.apr_qty_acc)" + 
			" as apr_qty from t_grn_gvn_header,m_franchisee,t_grn_gvn WHERE "
			+ " m_franchisee.fr_id=t_grn_gvn_header.fr_id AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate "
			+ " AND t_grn_gvn_header.is_grn IN (:isGrn) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND "
			+ " t_grn_gvn.fr_id=m_franchisee.fr_id GROUP by t_grn_gvn.fr_id",nativeQuery=true)*/
	@Query(value="select a.is_grn,a.fr_id,a.apr_grand_total,a.total_amt,a.fr_name,a.req_qty,a.apr_qty,coalesce(( b.bill_amt-c.grn_grand_total),0)  as fr_contr " + 
			"\n" + 
			"\n" + 
			"from\n" + 
			"(\n" + 
			"SELECT t_grn_gvn_header.is_grn,t_grn_gvn_header.fr_id, \n" + 
			"			 sum(t_grn_gvn.apr_grand_total)as apr_grand_total, sum(t_grn_gvn.grn_gvn_amt) as total_amt,\n" + 
			"		     m_franchisee.fr_name,sum(t_grn_gvn.grn_gvn_qty) as req_qty,sum(t_grn_gvn.apr_qty_acc) \n" + 
			"		     as apr_qty \n" + 
			"		     from t_grn_gvn_header,m_franchisee,t_grn_gvn \n" + 
			"		     \n" + 
			"		     WHERE " + 
			"		      m_franchisee.fr_id=t_grn_gvn_header.fr_id AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		      AND t_grn_gvn_header.is_grn IN (:isGrn) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id AND \n" + 
			"			   t_grn_gvn.fr_id=m_franchisee.fr_id  and t_grn_gvn.grn_gvn_status=6  GROUP by t_grn_gvn.fr_id\n" + 
			") a\n" + 
			"LEFT JOIN \n" + 
			"(	   \n" + 
			"			 SELECT   t_grn_gvn_header.fr_id,sum((t_bill_detail.grand_total/t_bill_detail.bill_qty)*t_grn_gvn.apr_qty_acc) as bill_amt FROM t_grn_gvn_header,t_grn_gvn,t_bill_detail WHERE t_grn_gvn_header.grn_gvn_header_id= t_grn_gvn.grn_gvn_header_id and t_grn_gvn.bill_detail_no=t_bill_detail.bill_detail_no " + 
			"		   AND t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		      AND t_grn_gvn.is_grn IN (:isGrn)  and t_grn_gvn.grn_gvn_status=6  GROUP by t_grn_gvn_header.fr_id ) b on b.fr_id=a.fr_id  LEFT JOIN \n" + 
			"(	   \n" + 
			"			SELECT t_grn_gvn_header.fr_id, \n" + 
			"			 sum(t_grn_gvn.apr_grand_total)as grn_grand_total\n" + 
			"		     from t_grn_gvn_header,t_grn_gvn \n" + 
			"		     \n" + 
			"		     WHERE  " + 
			"		    t_grn_gvn_header.grngvn_date BETWEEN :fromDate and :toDate\n" + 
			"		      AND t_grn_gvn_header.is_grn IN (1) AND t_grn_gvn_header.grn_gvn_header_id=t_grn_gvn.grn_gvn_header_id  and t_grn_gvn.grn_gvn_status=6  GROUP by t_grn_gvn.fr_id) c\n" + 
			"		      on c.fr_id=a.fr_id",nativeQuery=true)
		List<GGReportGrpByFrId> getGGReportGrpByFrIdSelFrAllFr(@Param("fromDate") 
		String fromDate,@Param("toDate") String toDate, @Param("isGrn") List<String> isGrn);
	
	
	
	

}
