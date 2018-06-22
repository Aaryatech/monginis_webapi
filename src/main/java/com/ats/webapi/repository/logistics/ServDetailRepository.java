package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.ServDetail;

public interface ServDetailRepository extends JpaRepository<ServDetail, Integer>{

	List<ServDetail> findByServIdAndDelStatus(int servId,int delStatus);

	@Transactional
	@Modifying
	@Query(value="delete from ServDetail where serv_id =:servId ") 
	void deleteServicingDetail(@Param("servId") int servId);

}
