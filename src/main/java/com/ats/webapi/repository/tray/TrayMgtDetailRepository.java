package com.ats.webapi.repository.tray;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.TrayMgtDetail;

@Repository
public interface TrayMgtDetailRepository extends JpaRepository<TrayMgtDetail, Integer>{


	TrayMgtDetail findByFrIdAndTranIdAndDelStatus(int frId, int tranId, int i);


	TrayMgtDetail findByFrIdAndTrayStatusAndIsSameDayAndDelStatus(int frId, int trayStatus, int isSameDay, int i);


	TrayMgtDetail findByTranDetailId(int tranStatus3);


	@Modifying
	@Transactional
	@Query("Update TrayMgtDetail  SET tray_status=:status WHERE tranDetailId =:tranStatus1")
	int updateTrayStatus(@Param("tranStatus1")int tranStatus1,@Param("status")int status);

}
