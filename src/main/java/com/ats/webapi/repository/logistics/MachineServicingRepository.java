package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.logistics.MachineServicing;

public interface MachineServicingRepository extends JpaRepository<MachineServicing, Integer>{

	List<MachineServicing> findAllByIsApprovedAndDelStatus(int isApproved, int delStatus);

}
