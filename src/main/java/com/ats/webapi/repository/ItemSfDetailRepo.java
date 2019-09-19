package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.SfItemDetailList;

public interface ItemSfDetailRepo extends JpaRepository<ItemSfDetail, Integer>{
	
	public ItemSfDetail save(ItemSfDetail itemSfDetail);
	
	List<ItemSfDetail> findByDelStatusAndSfId(int delStatus,int sfId);

	@Query(value="",nativeQuery=true)
	public ItemSfDetail getSfItemDetailsForCreamPrep(@Param("sfQty")float sfQty,@Param("sfId") int sfId);

}
