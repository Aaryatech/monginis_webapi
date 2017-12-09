package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MaterialRecNote;

@Repository
public interface MaterialRecNoteRepository extends JpaRepository<MaterialRecNote, Integer>{

	MaterialRecNote save(MaterialRecNote materialRecNote);

	
	@Query(value=" select * from t_material_receipt_note where status IN (:status) AND del_status=0",nativeQuery=true)
	List<MaterialRecNote> getMaterialByStatus(@Param("status") List<String> status);

	MaterialRecNote findByMrnId(int mrnId);

}
