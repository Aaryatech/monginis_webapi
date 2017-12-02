package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MaterialRecNote;

@Repository
public interface MaterialRecNoteRepository extends JpaRepository<MaterialRecNote, Integer>{

	MaterialRecNote save(MaterialRecNote materialRecNote);

	List<MaterialRecNote> findMaterialRecNoteByDelStatus(int delStatus);

}
