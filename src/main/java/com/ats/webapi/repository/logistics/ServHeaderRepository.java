package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.logistics.ServHeader;

public interface ServHeaderRepository extends JpaRepository<ServHeader, Integer>{

	List<ServHeader> findAllByDelStatus(int delStatus);

	ServHeader findByServId(int servId);

}
