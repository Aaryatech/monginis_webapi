package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Event;
import com.ats.webapi.model.afe.GetAfeScoreHeader;


public interface EventRepository extends JpaRepository<Event, Integer>{
	public Event save(Event event);
	public List<Event> findAll();
	public List<Event> findByDelStatus(int i);
	public Event findOne(int speId);
	public List<Event> findByDelStatusOrderBySpeNameAsc(int i);
	
	//public List<Event> findBySpetIdIN(List<String> eventId);

	@Query(value="SELECT m_sp_event.* from m_sp_event where m_sp_event.spe_id IN (:eventId)" + 
			"",nativeQuery=true)
	
	public List<Event>  findBySpeIdIn(@Param("eventId")List<Integer> eventId);
	
}
