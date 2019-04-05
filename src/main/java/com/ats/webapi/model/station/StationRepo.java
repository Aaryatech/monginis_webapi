package com.ats.webapi.model.station;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StationRepo extends JpaRepository<Station, Integer> {

	List<Station> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Station SET del_status=:delStatus WHERE usr_id=:stationId")
	int delteStation(@Param("stationId") int stationId, @Param("delStatus") int delStatus);

	Station findByStationIdAndDelStatus(int stationId, int i);

}
