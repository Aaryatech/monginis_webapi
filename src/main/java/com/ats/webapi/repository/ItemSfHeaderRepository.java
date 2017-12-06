package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.ItemSfHeader;

@Repository
public interface ItemSfHeaderRepository extends JpaRepository<ItemSfHeader, Integer>{


	List<ItemSfHeader> findItemSfHeaderByDelStatus(int delStatus);
	

}
