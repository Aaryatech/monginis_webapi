package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.tray.AllFrBalanceTrayReport;

public interface AllFrBalanceTrayReportRepo extends JpaRepository<AllFrBalanceTrayReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"    t.tran_detail_id,\r\n" + 
			"    t.tran_id,\r\n" + 
			"    t.fr_id,\r\n" + 
			"    SUM(t.balance_big) AS balance_big,\r\n" + 
			"    SUM(t.balance_small) AS balance_small,\r\n" + 
			"    SUM(t.balance_lead) AS balance_lead,\r\n" + 
			"    SUM(t.balance_extra) AS balance_extra,\r\n" + 
			"    f.fr_name\r\n" + 
			"FROM\r\n" + 
			"    t_tray_mgt_detail t,\r\n" + 
			"    m_franchisee f\r\n" + 
			"WHERE\r\n" + 
			"    t.fr_id = f.fr_id AND t.del_status = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    t.fr_id\r\n" + 
			"ORDER BY\r\n" + 
			"    fr_name", nativeQuery = true)
	List<AllFrBalanceTrayReport> getAllFrBalTray();

	
}
