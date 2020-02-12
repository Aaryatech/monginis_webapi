package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.webapi.model.ConfigureFranchisee;

@Repository
public interface ConfigureFrRepository extends JpaRepository<ConfigureFranchisee, Integer> {
	public ConfigureFranchisee save(ConfigureFranchisee configureFranchisee);

	public ConfigureFranchisee findBySettingId(int setting_id);

	@Query(value = "select menu_id from m_fr_configure WHERE fr_id=:frId ", nativeQuery = true)
	public List<Integer> findConfiguredMenuId(@Param("frId") int frId);

	// 23 march
	@Transactional
	@Modifying
	@Query(" UPDATE ConfigureFranchisee  SET fromTime=:fromTime, toTime=:toTime,settingType=:settingType,date=:date,day=:day "
			+ " WHERE frId IN(:frIdList) AND menuId =:menuId")
	int updateFrConfSelFr(@Param("frIdList") List<Integer> frIdList, @Param("menuId") int menuId,
			@Param("fromTime") String fromTime, @Param("toTime") String toTime,
			@Param("settingType") int settingType,@Param("date") String date,
			@Param("day") String day);//change this Sachin 11-02-2020 3 params added from settingType to day

	@Transactional
	@Modifying
	@Query(" UPDATE ConfigureFranchisee  SET fromTime=:fromTime, toTime=:toTime,settingType=:settingType,date=:date,day=:day WHERE  menuId =:menuId")
	int updateFrConfAllFr(@Param("menuId") int menuId, @Param("fromTime") String fromTime,
			@Param("toTime") String toTime,
			@Param("settingType") int settingType,@Param("date") String date,
			@Param("day") String day); //change this Sachin 11-02-2020 3 params added from settingType to day

	 ConfigureFranchisee findByFrIdAndMenuIdAndDelStatus(int frId, int menuId, int i);
	 
	 
	 @Query(value = "SELECT * FROM `m_fr_configure` WHERE fr_id IN (:frIds) AND menu_id IN(:menuIds) AND is_del=0 ", nativeQuery = true)
		public List<ConfigureFranchisee> findRecByFrAndMenu(@Param("frIds") List<Integer> frIds,@Param("menuIds") List<Integer> menuIds);
	 
	 
	// 21/6/2019
		@Transactional
		@Modifying
		@Query(" UPDATE ConfigureFranchisee  SET itemShow=:items "
				+ " WHERE settingId=:settingId")
		int updateItemList(@Param("items") String items, @Param("settingId") int settingId);

}
