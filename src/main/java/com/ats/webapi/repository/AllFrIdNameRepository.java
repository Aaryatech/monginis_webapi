package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.AllFrIdName;

public interface AllFrIdNameRepository extends JpaRepository<AllFrIdName, Integer> {
	
	@Query(value=" SELECT fr_id,fr_name from m_franchisee WHERE del_status=0 ",nativeQuery=true)
	
	List<AllFrIdName> getAllFrIdName();
	

}

