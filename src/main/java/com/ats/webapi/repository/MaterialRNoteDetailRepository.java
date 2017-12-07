package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MaterialRecNoteDetails;

@Repository
public interface MaterialRNoteDetailRepository extends JpaRepository<MaterialRecNoteDetails, Integer>{

	MaterialRecNoteDetails save(MaterialRecNoteDetails materialRecNoteDetails);

	List<MaterialRecNoteDetails> findByMrnId(int mrnId);

	
}
