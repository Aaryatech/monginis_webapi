package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.tray.NewTrayReport;

public interface NewTrayReportRepo extends JpaRepository<NewTrayReport, Integer>{
	
	
	 @Query(value="SELECT\r\n" + 
	 		"    UUID() AS id, t1.tran_id, t1.tran_detail_id, DATE_FORMAT(t1.outtray_date,'%d-%m-%Y') AS outtray_date, t1.outtray_small, t1.outtray_big, t1.outtray_lead, t2.intray_id, t2.tran_intray_id, DATE_FORMAT(t2.intray_date,'%d-%m-%Y') AS intray_date, t2.intray_small, t2.intray_big, t2.intray_lead, COALESCE(\r\n" + 
	 		"        (t1.outtray_small - t3.small_tot),\r\n" + 
	 		"        0\r\n" + 
	 		"    ) AS bal_small,\r\n" + 
	 		"    COALESCE((t1.outtray_big - t3.big_tot),\r\n" + 
	 		"    0) AS bal_big,\r\n" + 
	 		"    COALESCE(\r\n" + 
	 		"        (t1.outtray_lead - t3.lead_tot),\r\n" + 
	 		"        0\r\n" + 
	 		"    ) AS bal_lead\r\n" + 
	 		"FROM\r\n" + 
	 		"    (\r\n" + 
	 		"    SELECT\r\n" + 
	 		"        d.*\r\n" + 
	 		"    FROM\r\n" + 
	 		"        t_tray_mgt_detail d\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        d.del_status = 0 AND d.outtray_date BETWEEN :fromDate AND :toDate AND d.fr_id = :frId\r\n" + 
	 		") t1\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT i.*\r\n" + 
	 		"    FROM\r\n" + 
	 		"        t_tray_mgmt_detail_intray i\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        i.fr_id = :frId\r\n" + 
	 		") t2\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.tran_detail_id = t2.tran_detail_id\r\n" + 
	 		"LEFT JOIN(\r\n" + 
	 		"    SELECT i.tran_detail_id,\r\n" + 
	 		"        SUM(i.intray_small) AS small_tot,\r\n" + 
	 		"        SUM(i.intray_big) AS big_tot,\r\n" + 
	 		"        SUM(i.intray_lead) AS lead_tot\r\n" + 
	 		"    FROM\r\n" + 
	 		"        t_tray_mgmt_detail_intray i\r\n" + 
	 		"    WHERE\r\n" + 
	 		"        i.fr_id = :frId\r\n" + 
	 		"    GROUP BY\r\n" + 
	 		"        i.tran_detail_id\r\n" + 
	 		") t3\r\n" + 
	 		"ON\r\n" + 
	 		"    t1.tran_detail_id = t3.tran_detail_id\r\n" + 
	 		"ORDER BY\r\n" + 
	 		"    t1.outtray_date,\r\n" + 
	 		"    t2.intray_date",nativeQuery=true)
		List<NewTrayReport> getFrWiseTrayReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frId") int frId);
	   
	 
}
