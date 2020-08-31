package com.ats.webapi.repository.tray;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.TrayMgtDetailBean;
@Repository
public interface TrayMgtDetailBeanRepository extends JpaRepository<TrayMgtDetailBean, Integer>{

	TrayMgtDetailBean findByTranDetailId(int tranStatus3);



	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET tray_status=:status WHERE tranDetailId =:tranStatus1")
	int updateTrayStatus(@Param("tranStatus1")int tranStatus1,@Param("status")int status);
	
	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET tray_status=:status WHERE tranId =:tranStatus1")
	int updateTrayStatusByTranId(@Param("tranStatus1")int tranStatus1,@Param("status")int status);


	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET del_status=1 WHERE tranId =:tranId")
	int updateDelStatus(@Param("tranId")int tranId);
	
	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET balance_big=:balanceBig,balance_small=:balanceSmall,balance_lead=:balanceLead,"
			+ "tray_status=:trayStatus WHERE tranDetailId =:tranDetailId")
	int updateTrayAndUpdateForApp(@Param("trayStatus") int trayStatus, @Param("tranDetailId") int tranDetailId,
			@Param("balanceBig") int balanceBig, @Param("balanceSmall") int balanceSmall,
			@Param("balanceLead") int balanceLead);
}
