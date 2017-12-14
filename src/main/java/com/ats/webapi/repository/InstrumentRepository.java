package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer>{

	Instrument findInstrumentByInstrumentId(int instrumentId);

	 @Transactional
	 @Modifying
	 @Query("UPDATE Instrument SET del_status=1 WHERE instrument_id=:instrumentId")
	int deleteByInstrumentId(@Param("instrumentId")int instrumentId);

	List<Instrument> findAllByDelStatus(int i);

}
