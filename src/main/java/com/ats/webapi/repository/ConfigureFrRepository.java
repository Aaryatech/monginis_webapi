package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ConfigureFranchisee;

@Repository
public interface ConfigureFrRepository extends JpaRepository<ConfigureFranchisee, Integer>{ 
	public ConfigureFranchisee save(ConfigureFranchisee configureFranchisee);
	
	
	public ConfigureFranchisee findBySettingId(int setting_id);

     @Query(value="select menu_id from m_fr_configure WHERE fr_id=:frId ",nativeQuery=true)
	public List<Integer> findConfiguredMenuId(@Param("frId")int frId);
	
}
