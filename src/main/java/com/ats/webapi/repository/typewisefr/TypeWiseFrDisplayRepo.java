package com.ats.webapi.repository.typewisefr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.typewisefr.TypeWiseFrDisplay;

public interface TypeWiseFrDisplayRepo extends JpaRepository<TypeWiseFrDisplay, Integer>{
	

	@Query(value = " SELECT t.*, COALESCE(( SELECT GROUP_CONCAT(' ',f.fr_name) FROM m_franchisee f "
			+ "WHERE FIND_IN_SET(f.fr_id, t.fr_ids) ), 'na' ) AS fr_name FROM `m_typewise_fr` t  ", nativeQuery = true)
	List<TypeWiseFrDisplay> getTypeWiseFrList();
	
}