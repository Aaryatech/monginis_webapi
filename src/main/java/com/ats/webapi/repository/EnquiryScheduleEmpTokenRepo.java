package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.EnquiryScheduleEmpToken;

public interface EnquiryScheduleEmpTokenRepo extends JpaRepository<EnquiryScheduleEmpToken, Integer>{

	@Query(value="SELECT emp_id,token1 FROM m_app_emp WHERE FIND_IN_SET(emp_id,(SELECT setting_value1 from t_setting_new WHERE setting_key=:key))",nativeQuery=true)
	List<EnquiryScheduleEmpToken> getUserTokens(@Param("key") String key);
	
	
}
