package com.ats.webapi.repository.bmsstock;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.prod.GetProdPlanHeader;
import com.ats.webapi.model.stock.GetBmsCurrentStock;

@Repository
public interface GetCurrentBmsStockRepo extends JpaRepository<GetBmsCurrentStock, Integer> {
	
	
	@Query(value=" SELECT m_rm.rm_uom_id,m_rm.rm_id, m_rm.rm_name, coalesce((Select SUM(t_req_bom_detail.rm_issue_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate AND t_req_bom.from_dept_id=:prodDeptId  AND t_req_bom_detail.rm_type=:rmType AND "
			+ "t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>0 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS prod_issue_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rejected_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ " AND t_req_bom_detail.rm_type=:rmType AND t_req_bom.from_dept_id=:prodDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id "
			+ "AND t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS prod_rejected_qty,\n" + 
			"\n" +  
			"coalesce((Select SUM( t_req_bom_detail.return_qty)"
			+ " FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate AND"
			+ " t_req_bom.from_dept_id=:prodDeptId AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.req_id=t_req_bom_detail.req_id AND t_req_bom.status>2 "
			+ "AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS prod_return_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rm_issue_qty) FROM "
			+ "t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate AND "
			+ "t_req_bom.from_dept_id=:mixDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND "
			+ " t_req_bom_detail.rm_type=:rmType AND t_req_bom.status>0 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS mixing_issue_qty, \n " + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rejected_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ "AND t_req_bom.from_dept_id=:mixDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id "
			+ "AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS mixing_rejected_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.return_qty)"
			+ " FROM t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ "AND  t_req_bom_detail.rm_type=:rmType AND t_req_bom.from_dept_id=:mixDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND"
			+ " t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS mixing_return_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rm_issue_qty) "
			+ "FROM t_req_bom_detail,t_req_bom where t_req_bom.approved_date=:curDate "
			+ "AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.from_dept_id=:storeDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id AND"
			+ " t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS store_issue_qty,\n" + 
			"\n" + 
			"coalesce((Select SUM( t_req_bom_detail.rejected_qty) FROM "
			+ " t_req_bom_detail,t_req_bom where t_req_bom.rej_approve_date=:curDate "
			+ "AND t_req_bom.from_dept_id=:storeDeptId AND t_req_bom.req_id=t_req_bom_detail.req_id "
			+ "AND t_req_bom_detail.rm_type=:rmType AND  t_req_bom.status>2 AND m_rm.rm_id=t_req_bom_detail.rm_id),0) AS store_rejected_qty \n" +
	
			" from t_req_bom,m_rm Group by rm_id",nativeQuery=true)
		
			List<GetBmsCurrentStock> getBmsCurStock(@Param("curDate") Date curDate,@Param("prodDeptId") int prodDeptId,@Param("mixDeptId") int mixDeptId,
					@Param("storeDeptId") int storeDeptId,@Param("rmType") int rmType);
		

}
