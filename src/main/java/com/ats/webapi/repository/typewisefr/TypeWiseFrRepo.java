package com.ats.webapi.repository.typewisefr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.typewisefr.TypeWiseFr;


public interface TypeWiseFrRepo  extends JpaRepository<TypeWiseFr, Integer>{
	
	List<TypeWiseFr> findAll();

	TypeWiseFr findByTypeId(int typeId);
}
